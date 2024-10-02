package com.qltb.service;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.GiaoVien;
import com.qltb.entity.TangTB;
import com.qltb.mapper.ChiTietTangTBMapper;
import com.qltb.mapper.TangTBMapper;
import com.qltb.model.request.create.TangTBCreateRequest;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.request.update.TangTBUpdateRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.repository.ChiTietTangTBRepository;
import com.qltb.repository.TangTBRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TangTBService {
    TangTBRepository tangTBRepository;
    TangTBMapper tangTBMapper;
    ChiTietTangTBMapper chiTietTangTBMapper;
    ThietBiService thietBiService;
    ChiTietTangTBRepository chiTietTangTBRepository;

    public TangTBResponse create(TangTBCreateRequest request) {
        TangTB tangTB = tangTBMapper.toTangTB(request);
        tangTB.setMaPhieuTang(generateMaPhieuTang());
        return tangTBMapper.toTangTBResponse(tangTBRepository.save(tangTB));
    }

    @Transactional
    public TangTBResponse duyetTangTB(String maPhieuTang, TangTBUpdateRequest request) {
        TangTB tangTB = tangTBRepository.findById(maPhieuTang).get();
        tangTB.setNgayLap(request.getNgayLap());
        tangTB.setNoiDung(request.getNoiDung());
        tangTB.setChoDuyet(false);
        List<ChiTietTangTB> chiTietTangTBList = new ArrayList<>(request.getChiTietTangTBList().stream().map(chiTietTangTBCreateRequest -> {
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
        tangTB.setChiTietTangTBList(chiTietTangTBList);
        return tangTBMapper.toTangTBResponse(tangTBRepository.save(tangTB));
    }

    public Page<TangTBResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuTang"));
        return tangTBRepository.getAll(pageable).map(tangTB -> {
            TangTBResponse tangTBResponse = tangTBMapper.toTangTBResponse(tangTB);
            tangTBResponse.setChiTietTangTBList(chiTietTangTBRepository.findAllByMaPhieuTang(tangTB.getMaPhieuTang()).stream().map(chiTietTangTBMapper::toChiTietTangTBResponse).toList());
            return tangTBResponse;
        });
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

    public void delete(String maPhieuTang) {
        tangTBRepository.deleteById(maPhieuTang);
    }
}
