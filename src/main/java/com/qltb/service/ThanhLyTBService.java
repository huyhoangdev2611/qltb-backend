package com.qltb.service;

import com.qltb.entity.ChiTietThanhLyTB;
import com.qltb.entity.ThanhLyTB;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.ChiTietThanhLyTBMapper;
import com.qltb.mapper.ThanhLyTBMapper;
import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.model.response.ThanhLyTBResponse;
import com.qltb.repository.ThanhLyTBRepository;
import com.qltb.repository.ThietBiRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public ThanhLyTBResponse create(ThanhLyTBCreateRequest request) {
        ThanhLyTB thanhLyTB = thanhLyTBMapper.toThanhLyTB(request);
        thanhLyTB.setMaPhieuThanhLy(generateMaPhieuThanhLy());
        thanhLyTB.setChiTietThanhLyTBList(request.getChiTietThanhLyTBList().stream().map(chiTietThanhLyTBCreateRequest -> {
            ChiTietThanhLyTB chiTietThanhLyTB = chiTietThanhLyTBMapper.toChiTietThanhLyTB(chiTietThanhLyTBCreateRequest, thanhLyTB.getMaPhieuThanhLy());
            ThietBi thietBi = thietBiRepository.findById(chiTietThanhLyTB.getMaCaBietTB()).get();
            thietBi.setTrangThai("Đã thanh lý");
            thietBiRepository.save(thietBi);
            return chiTietThanhLyTB;
        }).toList());
        return thanhLyTBMapper.toThanhLyTBResponse(thanhLyTBRepository.save(thanhLyTB));
    }

//    public Page<TangTBResponse> getAll(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuTang"));
//        return tangTBRepository.getAll(pageable).map(tangTBMapper::toTangTBResponse);
//    }

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
}
