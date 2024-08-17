package com.qltb.controller;

import com.qltb.model.request.create.BaoCaoKiemKeTB;
import com.qltb.model.request.create.BaoCaoThongKeCreateRequest;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.response.DashboardDataResponse;
import com.qltb.model.response.ThietBiResponse;
import com.qltb.service.ThietBiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thiet-bi")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThietBiController {
    ThietBiService thietBiService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ThietBiCreateRequest request) {
        thietBiService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page")
    public Page<ThietBiResponse> getTBs(@RequestParam int page, @RequestParam int size) {
        return thietBiService.getTBs(page, size);
    }

    @PatchMapping("/{maCaBietTB}")
    public ResponseEntity updateActivating(@PathVariable String maCaBietTB) {
        thietBiService.updateActivating(maCaBietTB);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<ThietBiResponse> getAllChuaThanhLy() {
        return thietBiService.getAllChuaThanhLy();
    }

    @GetMapping("/search")
    public Page<ThietBiResponse> search(@RequestParam(name = "name") String maCaBietTB, @RequestParam int page, @RequestParam int size) {
        return thietBiService.search(maCaBietTB, page, size);
    }

    @GetMapping("/search-all")
    public List<ThietBiResponse> searchAll(@RequestParam(name = "name") String maCaBietTB) {
        return thietBiService.search(maCaBietTB);
    }

    @GetMapping("/get-all-co-the-ghi-giam")
    public List<ThietBiResponse> getAllCoTheGhiGiam() {
        return thietBiService.getAllCoTheGhiGiam();
    }

    @GetMapping("/get-all-co-the-ghi-giam/search")
    public List<ThietBiResponse> getAllCoTheGhiGiam(@RequestParam(name = "name") String maCaBietTB) {
        return thietBiService.getAllCoTheGhiGiam(maCaBietTB);
    }

    @GetMapping("/tinh-trang-hien-hoat-dong")
    public ResponseEntity<List<ThietBiResponse>> getHienTrangHoatDongTot() {
        List<ThietBiResponse> thietBiResponses = thietBiService.getHienTrangHoatDongTot();
        return ResponseEntity.ok(thietBiResponses);
    }

    @GetMapping("/dashboard-data")
    public ResponseEntity<DashboardDataResponse> getDashboardData() {
        long totalDevices = thietBiService.getTotalDevices();
        long devicesInStorage = thietBiService.getDevicesInStorage();
        long brokenDevices = thietBiService.getBrokenDevices();
        long lostDevices = thietBiService.getLostDevices();

        DashboardDataResponse response = new DashboardDataResponse(totalDevices, devicesInStorage, brokenDevices, lostDevices);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-co-the-kbhm")
    public List<ThietBiResponse> getAllCoTheKBHM() {
        return thietBiService.getAllCoTheKBHM();
    }

    @PatchMapping("/sua-chua")
    public ThietBiResponse suaChua(@RequestParam String maPhieuBao, @RequestParam String maCaBietTB) {
        return thietBiService.suaChua(maPhieuBao, maCaBietTB);
    }

    @PatchMapping("/tim-thay")
    public ThietBiResponse timThay(@RequestParam String maPhieuBao, @RequestParam String maCaBietTB) {
        return thietBiService.timThay(maPhieuBao, maCaBietTB);
    }

    @PostMapping("/bao-cao-thong-ke")
    public ResponseEntity<?> baoCaoThongKe(@RequestBody BaoCaoThongKeCreateRequest request) {
        return switch (request.getOption()) {
            case "op2" -> ResponseEntity.ok(thietBiService.tkTBTang(request));
            case "op3" -> ResponseEntity.ok(thietBiService.tkThanhLyTB(request));
            case "op4" -> ResponseEntity.ok(thietBiService.tkTinhHinhMuonTBCuaGV(request));
            case "op5" -> ResponseEntity.ok(thietBiService.tkThietBiDangMuon(request));
            case "op6" -> ResponseEntity.ok(thietBiService.tkTBMuonQuaHan(request));
            case "op7" -> ResponseEntity.ok(thietBiService.tkSoLuongHongMatTieuHao(request));
            default -> ResponseEntity.ok(thietBiService.tkSoLuongTheoNTB());
        };
    }

    @PostMapping("/bao-cao-kiem-ke-tb")
    public ResponseEntity<?> baoCaoKiemKeTB(@RequestBody BaoCaoKiemKeTB request) {
        return ResponseEntity.ok(thietBiService.baoCaoKiemKeTB(request));
    }
}
