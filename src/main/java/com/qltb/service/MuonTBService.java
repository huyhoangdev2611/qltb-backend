package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.MuonTB;
import com.qltb.entity.ChiTietMuonTB;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.ChiTietMuonTBMapper;
import com.qltb.mapper.MuonTBMapper;
import com.qltb.model.request.create.MuonTBCreateRequest;
import com.qltb.model.request.update.MuonTBUpdateRequest;
import com.qltb.model.response.MuonTBResponse;
import com.qltb.repository.MuonTBRepository;
import com.qltb.repository.GiaoVienRepository;
import com.qltb.repository.ChiTietMuonTBRepository;
import com.qltb.repository.ThietBiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MuonTBService {
    private final MuonTBRepository muonTBRepository;
    private final GiaoVienRepository giaoVienRepository;
    private final ChiTietMuonTBRepository chiTietMuonTBRepository;
    private final ThietBiRepository thietBiRepository;
    private final MuonTBMapper muonTBMapper;
    private final ChiTietMuonTBMapper chiTietMuonTBMapper;

    public List<MuonTBResponse> findAll() {
        return muonTBRepository.findAll().stream()
                .map(this::updateStatusAndMapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<MuonTBResponse> findById(String id) {
        return muonTBRepository.findById(id)
                .map(this::updateStatusAndMapToResponse);
    }

    @Transactional
    public MuonTBResponse create(MuonTBCreateRequest request) {
        MuonTB muonTB = muonTBMapper.toMuonTB(request);
        muonTB.setMaPhieuMuon(generateMaPhieuMuon());
        updateStatusIfOverdue(muonTB);

        // Save MuonTB first
        MuonTB savedMuonTB = muonTBRepository.save(muonTB);

        List<ChiTietMuonTB> chiTietMuonTBList = Optional.ofNullable(request.getChiTietMuonTBList())
                .orElseGet(List::of)
                .stream()
                .map(chiTietRequest -> {
                    ChiTietMuonTB chiTietMuonTB = chiTietMuonTBMapper.toChiTietMuonTB(chiTietRequest);
                    chiTietMuonTB.setMaCaBietTB(chiTietRequest.getMaCaBietTB());
                    chiTietMuonTB.setMuonTB(savedMuonTB);
                    chiTietMuonTB.setMaPhieuMuon(savedMuonTB.getMaPhieuMuon());

                    // Update device status to "Đang mượn"
                    ThietBi thietBi = thietBiRepository.findById(chiTietRequest.getMaCaBietTB())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid device ID"));
                    thietBi.setTrangThai("Đang mượn");
                    thietBiRepository.save(thietBi);

                    return chiTietMuonTB;
                })
                .collect(Collectors.toList());

        chiTietMuonTBRepository.saveAll(chiTietMuonTBList);

        savedMuonTB.setChiTietMuonTBList(chiTietMuonTBList);
        return muonTBMapper.toMuonTBResponse(savedMuonTB);
    }

    @Transactional
    public void delete(String id) {
        MuonTB muonTB = muonTBRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid loan ID"));
        muonTBRepository.delete(muonTB);
    }

    public Page<MuonTBResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuMuon"));
        return muonTBRepository.findAll(pageable).map(muonTB -> {
            MuonTBResponse muonTBResponse = muonTBMapper.toMuonTBResponse(muonTB);
            for (int i = 0; i < muonTBResponse.getChiTietMuonTBList().size(); i++) {
                muonTBResponse.getChiTietMuonTBList().get(i).setTenThietBi(
                        muonTB.getChiTietMuonTBList().get(i).getThietBi().getNhomThietBi().getTenNTB()
                );
            }
            return muonTBResponse;
        });
    }

    private String generateMaPhieuMuon() {
        Optional<MuonTB> lastMuonTB = muonTBRepository.findTopByOrderByMaPhieuMuonDesc();
        if (lastMuonTB.isPresent()) {
            String lastMaPhieuMuon = lastMuonTB.get().getMaPhieuMuon();
            int nextId = Integer.parseInt(lastMaPhieuMuon.substring(2)) + 1;
            return String.format("PM%05d", nextId);
        } else {
            return "PM00001";
        }
    }

    @Transactional
    public MuonTBResponse updateMuonTB(String maPhieuMuon, MuonTBUpdateRequest updateRequest) {
        MuonTB muonTB = muonTBRepository.findById(maPhieuMuon)
                .orElseThrow(() -> new IllegalArgumentException("Invalid loan ID"));

        if (updateRequest.getTrangThai() != null) {
            muonTB.setTrangThai(updateRequest.getTrangThai());
        }

        updateStatusIfOverdue(muonTB);

        MuonTB updatedMuonTB = muonTBRepository.save(muonTB);
        return muonTBMapper.toMuonTBResponse(updatedMuonTB);
    }

    public Page<MuonTBResponse> searchByGiaoVien(String tenGiaoVien, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return muonTBRepository.findByGiaoVien_TenGVContainingIgnoreCaseOrderByMaPhieuMuonAsc(pageable, tenGiaoVien)
                .map(this::updateStatusAndMapToResponse);
    }

    private MuonTBResponse updateStatusAndMapToResponse(MuonTB muonTB) {
        updateStatusIfOverdue(muonTB);
        MuonTBResponse muonTBResponse = muonTBMapper.toMuonTBResponse(muonTB);
        for (int i = 0; i < muonTBResponse.getChiTietMuonTBList().size(); i++) {
            muonTBResponse.getChiTietMuonTBList().get(i).setTenThietBi(
                    muonTB.getChiTietMuonTBList().get(i).getThietBi().getNhomThietBi().getTenNTB()
            );
        }
        return muonTBResponse;
    }

    private void updateStatusIfOverdue(MuonTB muonTB) {
        LocalDate ngayHenTra = muonTB.getNgayHenTra();
        if (ngayHenTra != null && ngayHenTra.isBefore(LocalDate.now())) {
            muonTB.setTrangThai("quá hạn");
        }
    }
}
