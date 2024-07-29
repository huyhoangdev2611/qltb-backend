package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.TangTB;
import com.qltb.mapper.ChiTietTangTBMapper;
import com.qltb.mapper.TangTBMapper;
import com.qltb.model.request.create.TangTBCreateRequest;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.repository.TangTBRepository;
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
public class TangTBService {
    TangTBRepository tangTBRepository;
    TangTBMapper tangTBMapper;
    ChiTietTangTBMapper chiTietTangTBMapper;
    ThietBiService thietBiService;

    public TangTBResponse create(TangTBCreateRequest request) {
        TangTB tangTB = tangTBMapper.toTangTB(request);
        tangTB.setMaPhieuTang(generateMaPhieuTang());
        tangTB.setChiTietTangTBList(request.getChiTietTangTBList().stream().map(chiTietTangTBCreateRequest -> {
            chiTietTangTBCreateRequest.setMaPhieuTang(tangTB.getMaPhieuTang());
            ThietBiCreateRequest thietBiCreateRequest = ThietBiCreateRequest.builder()
                    .maNTB(chiTietTangTBCreateRequest.getMaNTB())
                    .maKP(chiTietTangTBCreateRequest.getMaKP())
                    .hanSuDung(chiTietTangTBCreateRequest.getHanSuDung())
                    .ngayNhap(chiTietTangTBCreateRequest.getNgayNhap())
                    .soLuong(chiTietTangTBCreateRequest.getSoLuong())
                    .build();
            thietBiService.create(thietBiCreateRequest);
            return chiTietTangTBMapper.toChiTietTangTB(chiTietTangTBCreateRequest);
        }).toList());
        return tangTBMapper.toTangTBResponse(tangTBRepository.save(tangTB));
    }

    public Page<TangTBResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuTang"));
        return tangTBRepository.getAll(pageable).map(tangTBMapper::toTangTBResponse);
    }

    private String generateMaPhieuTang() {
        Optional<TangTB> lastTangTB = tangTBRepository.findTopByOrderByMaPhieuTangDesc();
        if (lastTangTB.isPresent()) {
            String lastMaPhieuTang = lastTangTB.get().getMaPhieuTang();
            int nextId = Integer.parseInt(lastMaPhieuTang.substring(2)) + 1;
            return String.format("PT%05d", nextId);
        } else {
            return "PT00001";
        }
    }
}
