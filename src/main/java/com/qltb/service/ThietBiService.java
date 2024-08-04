package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.NhomThietBi;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.ThietBiMapper;
import com.qltb.model.request.create.BaoCaoThongKeCreateRequest;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.request.update.ThietBiUpdateRequest;
import com.qltb.model.response.*;
import com.qltb.repository.NhomThietBiRepository;
import com.qltb.repository.TheoDoiHongMatRepository;
import com.qltb.repository.ThietBiRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThietBiService {
    ThietBiRepository thietBiRepository;
    ThietBiMapper thietBiMapper;
    NhomThietBiRepository nhomThietBiRepository;
    TheoDoiHongMatRepository theoDoiHongMatRepository;

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

    public List<ThietBiResponse> getAllCoTheKBHM() {
        return thietBiRepository.getAllCoTheKBHM().stream().map(thietBiMapper::toThietBiResponse).toList();
    }

    @Transactional
    public ThietBiResponse suaChua(String maPhieuBao, String maCaBietTB) {
        Optional<ThietBi> thietBi = thietBiRepository.findById(maCaBietTB);
        if (thietBi.isPresent()) {
            thietBi.get().setTinhTrang("Dùng được");
            thietBiRepository.save(thietBi.get());
            theoDoiHongMatRepository.deleteById(maPhieuBao);
        }
        return thietBiMapper.toThietBiResponse(thietBi.get());
    }

    @Transactional
    public ThietBiResponse timThay(String maPhieuBao, String maCaBietTB) {
        Optional<ThietBi> thietBi = thietBiRepository.findById(maCaBietTB);
        if (thietBi.isPresent()) {
            thietBi.get().setTrangThai("Trong kho");
            thietBiRepository.save(thietBi.get());
            theoDoiHongMatRepository.deleteById(maPhieuBao);
        }
        return thietBiMapper.toThietBiResponse(thietBi.get());
    }

    public List<TKSoLuongTheoNTBResponse> tkSoLuongTheoNTB() {
        return thietBiRepository.tkSoLuongTheoNTB();
    }

    public List<TKTBTangResponse> tkTBTang(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        return thietBiRepository.tkTBTang(tuNgay, denNgay);
    }

    public List<TKThanhLyResponse> tkThanhLyTB(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        return thietBiRepository.tkThanhLyTB(tuNgay, denNgay);
    }

    public List<TKTinhHinhMuonTBCuaGVResponse> tkTinhHinhMuonTBCuaGV(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        List<TKTinhHinhMuonTBCuaGVResponse> responses = thietBiRepository.tkTinhHinhMuonTBCuaGV(tuNgay, denNgay);
        responses.forEach(response -> {
            response.setThongTins(thietBiRepository.thongTinMuonTBCuaGiaoVien(response.getTenGV(), tuNgay, denNgay));
        });
        return responses;
    }

    public List<TKThietBiDangMuonResponse> tkThietBiDangMuon(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        return thietBiRepository.tkThietBiDangMuon(tuNgay, denNgay);
    }

    public List<TKThietBiDangMuonResponse> tkTBMuonQuaHan(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        return thietBiRepository.tkTBMuonQuaHan(tuNgay, denNgay);
    }

    public List<TKSoLuongHongMatTieuHaoResponse> tkSoLuongHongMatTieuHao(BaoCaoThongKeCreateRequest request) {
        LocalDate tuNgay = request.getTuNgay();
        LocalDate denNgay = request.getDenNgay();
        return thietBiRepository.tkSoLuongHongMatTieuHao(tuNgay, denNgay);
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

    public long getTotalDevices() {
        return thietBiRepository.count();
    }

    public long getDevicesInStorage() {
        return thietBiRepository.countByTrangThaiTrongKho();
    }

    public long getBrokenDevices() {
        return thietBiRepository.countByTinhTrangHong();
    }

    public long getLostDevices() {
        return thietBiRepository.countByTrangThaiDaMat();
    }

}
