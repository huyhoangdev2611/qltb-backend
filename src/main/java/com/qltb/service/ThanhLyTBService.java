package com.qltb.service;

import com.qltb.entity.ChiTietThanhLyTB;
import com.qltb.entity.TangTB;
import com.qltb.entity.ThanhLyTB;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.ChiTietThanhLyTBMapper;
import com.qltb.mapper.ThanhLyTBMapper;
import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.request.update.TangTBUpdateRequest;
import com.qltb.model.request.update.ThanhLyTBUpdateRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.model.response.ThanhLyTBResponse;
import com.qltb.repository.ChiTietThanhLyTBRepository;
import com.qltb.repository.ThanhLyTBRepository;
import com.qltb.repository.ThietBiRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThanhLyTBService {
    ThanhLyTBRepository thanhLyTBRepository;
    ThietBiService thietBiService;
    ThanhLyTBMapper thanhLyTBMapper;
    ChiTietThanhLyTBMapper chiTietThanhLyTBMapper;
    ThietBiRepository thietBiRepository;
    ChiTietThanhLyTBRepository chiTietThanhLyTBRepository;
    private final TangTBService tangTBService;

    public ThanhLyTBResponse create(ThanhLyTBCreateRequest request) {
        ThanhLyTB thanhLyTB = thanhLyTBMapper.toThanhLyTB(request);
        thanhLyTB.setMaPhieuThanhLy(generateMaPhieuThanhLy());
        thanhLyTB.setChiTietThanhLyTBList(request.getChiTietThanhLyTBList().stream().map(chiTietThanhLyTBCreateRequest -> {
            ChiTietThanhLyTB chiTietThanhLyTB = chiTietThanhLyTBMapper.toChiTietThanhLyTB(chiTietThanhLyTBCreateRequest, thanhLyTB.getMaPhieuThanhLy());
            ThietBi thietBi = thietBiRepository.findById(chiTietThanhLyTB.getMaCaBietTB()).get();
            thietBi.setTrangThai("Đã thanh lý");
//            thietBi.setDangHoatDong(false);
            thietBiRepository.save(thietBi);
            return chiTietThanhLyTB;
        }).toList());
        return thanhLyTBMapper.toThanhLyTBResponse(thanhLyTBRepository.save(thanhLyTB));
    }

    public Page<ThanhLyTBResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuThanhLy"));
        return thanhLyTBRepository.findAll(pageable).map(thanhLyTB -> {
            ThanhLyTBResponse thanhLyTBResponse = thanhLyTBMapper.toThanhLyTBResponse(thanhLyTB);
            thanhLyTBResponse.setChiTietThanhLyTBList(thanhLyTB.getChiTietThanhLyTBList().stream().map(chiTietThanhLyTBMapper::toChiTietThanhLyTBResponse).toList());
            return thanhLyTBResponse;
        });
    }

    private String generateMaPhieuThanhLy() {
        Optional<ThanhLyTB> lastTangTB = thanhLyTBRepository.findTopByOrderByMaPhieuThanhLyDesc();
        if (lastTangTB.isPresent()) {
            String lastMaPhieuThanhLy = lastTangTB.get().getMaPhieuThanhLy();
            int nextId = Integer.parseInt(lastMaPhieuThanhLy.substring(2)) + 1;
            return String.format("PG%05d", nextId);
        } else {
            return "PG00001";
        }
    }

    public Page<ThanhLyTBResponse> search(String maPhieuThanhLy, int page, int size) {
        return thanhLyTBRepository.findByMaPhieuThanhLyContainingIgnoreCaseOrderByMaPhieuThanhLyAsc(maPhieuThanhLy, PageRequest.of(page, size)).map(thanhLyTBMapper::toThanhLyTBResponse);
    }

    @Transactional
    public void huyThanhLyTB(String maCaBietTB) {
        ThietBi thietBi = thietBiRepository.findById(maCaBietTB).get();
        thietBi.setTrangThai("Trong kho");
        chiTietThanhLyTBRepository.deleteByMaCaBietTB(maCaBietTB);
        thietBiRepository.save(thietBi);
    }

    public ThanhLyTBResponse update(String maPhieuThanhLy, ThanhLyTBUpdateRequest request) {
        ThanhLyTB thanhLyTB = thanhLyTBRepository.findById(maPhieuThanhLy).get();
        thanhLyTBMapper.updateThanhLyTB(thanhLyTB, request);
        return thanhLyTBMapper.toThanhLyTBResponse(thanhLyTBRepository.save(thanhLyTB));
    }

    public void delete(String maPhieuThanhLy) {
        thanhLyTBRepository.deleteById(maPhieuThanhLy);
    }
}
