package com.qltb.service;

import com.qltb.entity.MuonTB;
import com.qltb.entity.ThietBi;
import com.qltb.entity.TraTB;
import com.qltb.entity.ChiTietTraTB;
import com.qltb.mapper.ChiTietTraTBMapper;
import com.qltb.mapper.TraTBMapper;
import com.qltb.model.request.create.TraTBCreateRequest;
import com.qltb.model.response.MuonTBResponse;
import com.qltb.model.response.TraTBResponse;
import com.qltb.repository.MuonTBRepository;
import com.qltb.repository.ThietBiRepository;
import com.qltb.repository.TraTBRepository;
import com.qltb.repository.ChiTietTraTBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TraTBService {
    private final TraTBRepository traTBRepository;
    private final ChiTietTraTBRepository chiTietTraTBRepository;
    private final ThietBiRepository thietBiRepository;
    private final TraTBMapper traTBMapper;
    private final ChiTietTraTBMapper chiTietTraTBMapper;
    private final MuonTBRepository muonTBRepository;

    public List<TraTBResponse> findAll() {
        return traTBRepository.findAll().stream()
                .map(traTBMapper::toTraTBResponse)
                .collect(Collectors.toList());
    }

    public Page<TraTBResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuTra"));
        return traTBRepository.findAll(pageable).map(traTBMapper::toTraTBResponse);
    }

    @Transactional
    public TraTBResponse create(TraTBCreateRequest request) {
        TraTB traTB = new TraTB();
        traTBMapper.updateTraTBFromRequest(request, traTB);
        traTB.setMaPhieuTra(generateMaPhieuTra());

        // Fetch and set MuonTB
        MuonTB muonTB = muonTBRepository.findById(request.getMaPhieuMuon())
                .orElseThrow(() -> new IllegalArgumentException("Invalid loan ID"));
        traTB.setMuonTB(muonTB);

        // Save TraTB first
        TraTB savedTraTB = traTBRepository.save(traTB);

        List<ChiTietTraTB> chiTietTraTBList = request.getChiTietTraTBList().stream()
                .map(chiTietRequest -> {
                    ChiTietTraTB chiTietTraTB = chiTietTraTBMapper.toChiTietTraTB(chiTietRequest);
                    chiTietTraTB.setTraTB(savedTraTB);
                    chiTietTraTB.setMaPhieuTra(savedTraTB.getMaPhieuTra());

                    // Fetch ThietBi and update its status based on tinhTrangTra
                    ThietBi thietBi = thietBiRepository.findById(chiTietRequest.getMaCaBietTB())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid device ID"));

                    // Update the status of ThietBi based on tinhTrangTra
                    String tinhTrangTra = chiTietRequest.getTinhTrangTra();
                    if ("Đã tiêu hao".equals(tinhTrangTra)) {
                        thietBi.setTrangThai("Đã tiêu hao");
                    } else {
                        thietBi.setTrangThai("Trong kho");
                    }
                    thietBi.setTinhTrang(tinhTrangTra);

                    thietBiRepository.save(thietBi);

                    return chiTietTraTB;
                })
                .collect(Collectors.toList());

        chiTietTraTBRepository.saveAll(chiTietTraTBList);
        savedTraTB.setChiTietTraTBList(chiTietTraTBList);

        // Update MuonTB status to "Đã trả"
        muonTB.setTrangThai("Đã trả");
        muonTBRepository.save(muonTB);

        return traTBMapper.toTraTBResponse(savedTraTB);
    }



    public TraTBResponse findById(String id) {
        return traTBRepository.findById(id)
                .map(traTBMapper::toTraTBResponse)
                .orElse(null);
    }

    @Transactional
    public void delete(String id) {
        TraTB traTB = traTBRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid return ID"));
        traTBRepository.delete(traTB);
    }

    private String generateMaPhieuTra() {
        Optional<TraTB> lastTraTB = traTBRepository.findTopByOrderByMaPhieuTraDesc();
        if (lastTraTB.isPresent()) {
            String lastMaPhieuTra = lastTraTB.get().getMaPhieuTra();
            int nextId = Integer.parseInt(lastMaPhieuTra.substring(2)) + 1;
            return String.format("PT%05d", nextId);
        } else {
            return "PT00001";
        }
    }

    public Page<TraTBResponse> searchByTenGV(String tenGV, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return traTBRepository.findByMuonTB_GiaoVien_TenGVContainingIgnoreCaseOrderByMaPhieuTraAsc(pageable, tenGV)
                .map(traTBMapper::toTraTBResponse);
    }
}




