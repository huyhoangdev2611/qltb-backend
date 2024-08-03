package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.NhomThietBi;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.ThietBiMapper;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.request.update.ThietBiUpdateRequest;
import com.qltb.model.response.ThietBiResponse;
import com.qltb.repository.NhomThietBiRepository;
import com.qltb.repository.ThietBiRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThietBiService {
    @Autowired
    ThietBiRepository thietBiRepository;
    @Autowired
    ThietBiMapper thietBiMapper;
    @Autowired
    NhomThietBiRepository nhomThietBiRepository;

    public Page<ThietBiResponse> getTBs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maCaBietTB"));
        Page<ThietBi> thietBis = thietBiRepository.findAll(pageable);
        return thietBis.map(thietBi -> {
            ThietBiResponse thietBiResponse = thietBiMapper.toThietBiResponse(thietBi);
            thietBiResponse.setKhoPhong(thietBi.getKhoPhong().getTenKP());
            thietBiResponse.setTenNTB(thietBi.getNhomThietBi().getTenNTB());
            return thietBiResponse;
        });
    }

    public void updateActivating(String maCaBietTB) {
        Optional<ThietBi> thietBi = thietBiRepository.findById(maCaBietTB);
        if (thietBi.isPresent()) {
            thietBi.get().setDangHoatDong(!thietBi.get().isDangHoatDong());
            thietBiRepository.save(thietBi.get());
        }
    }

    public void create(ThietBiCreateRequest request) {
        for (int i = 0; i < request.getSoLuong(); i++) {
//            ThietBi thietBi = new ThietBi();
//            thietBi.setMaNTB(request.getMaNTB());
//            thietBi.setMaKP(request.getMaKP());
//            thietBi.setNgayNhap(request.getNgayNhap());
//            thietBi.setHanSuDung(request.getHanSuDung());
//            thietBi.setMaCaBietTB(generateMaCB(request.getMaNTB()));
//
//            thietBiRepository.save(thietBi);
            ThietBi thietBi = thietBiMapper.toThietBi(request);
            thietBi.setMaCaBietTB(generateMaCB(request.getMaNTB()));
            thietBiRepository.save(thietBi);
        }
    }

    public List<ThietBiResponse> getAllChuaThanhLy() {
        return thietBiRepository.findAllChuaThanhLy(Sort.by(Sort.Direction.ASC, "maCaBietTB")).stream().map(thietBiMapper::toThietBiResponse).toList();
    }

    public Page<ThietBiResponse> search(String maCaBietThietBi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return thietBiRepository.findByMaCaBietTBContainingIgnoreCaseOrderByMaCaBietTB(maCaBietThietBi, pageable).map(thietBiMapper::toThietBiResponse);
    }

    public List<ThietBiResponse> search(String maCaBietThietBi) {
        return thietBiRepository.findByMaCaBietTBContainingIgnoreCaseOrderByMaCaBietTB(maCaBietThietBi).stream().map(thietBiMapper::toThietBiResponse).toList();
    }

    private String generateMaCB(String maNTB) {
        int amount = thietBiRepository.countTB(maNTB);
        return maNTB + "-" + (amount + 1);
    }

    public List<ThietBiResponse> getAllCoTheGhiGiam() {
        return thietBiRepository.getAllCoTheGhiGiam().stream().map(thietBiMapper::toThietBiResponse).toList();
    }

    public List<ThietBiResponse> getAllCoTheGhiGiam(String maCaBietTB) {
        return thietBiRepository.getAllCoTheGhiGiam(maCaBietTB).stream().map(thietBiMapper::toThietBiResponse).toList();
    }

    public List<ThietBiResponse> getHienTrangHoatDongTot() {
        List<ThietBi> thietBiList = thietBiRepository.getAllCoTheMuon();
        return thietBiList.stream().map(thietBiMapper::toThietBiResponse).collect(Collectors.toList());
    }


//    private String generateMaCB(String maNTB) {
//        List<ThietBi> thietBis = thietBiRepository.findByMaNTB(maNTB);
//        Optional<ThietBi> lastThietBi = thietBis.stream()
//                .sorted((tb1, tb2) -> {
//                    int num1 = Integer.parseInt(tb1.getMaCaBietTB().substring(tb1.getMaCaBietTB().lastIndexOf('-') + 1));
//                    int num2 = Integer.parseInt(tb2.getMaCaBietTB().substring(tb2.getMaCaBietTB().lastIndexOf('-') + 1));
//                    return Integer.compare(num2, num1);
//                })
//                .findFirst();
//
//        if (lastThietBi.isPresent()) {
//            String lastMaCaBietTB = lastThietBi.get().getMaCaBietTB();
//            int nextId = Integer.parseInt(lastMaCaBietTB.substring(lastMaCaBietTB.lastIndexOf('-') + 1)) + 1;
//            return maNTB + "-" + nextId;
//        } else {
//            return maNTB + "-1";
//        }
//    }

}
