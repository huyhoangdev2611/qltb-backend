package com.qltb.controller;

import com.qltb.model.request.create.MuonTBCreateRequest;
import com.qltb.model.request.update.MuonTBUpdateRequest;
import com.qltb.model.request.update.MuonTBUpdateStatusRequest;
import com.qltb.model.response.MonthlyBorrowedDevicesResponse;
import com.qltb.model.response.MuonTBResponse;
import com.qltb.service.MuonTBService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/muon-tb")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MuonTBController {
    MuonTBService muonTBService;

    @PostMapping("/create")
    public MuonTBResponse create(@RequestBody MuonTBCreateRequest request) {
        request.setTrangThai("Đang mượn");
        return muonTBService.create(request);
    }

    @GetMapping
    public List<MuonTBResponse> getAll() {
        return muonTBService.findAll();
    }

    @GetMapping("/page")
    public Page<MuonTBResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return muonTBService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public MuonTBResponse findById(@PathVariable String id) {
        return muonTBService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan not found")
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        muonTBService.delete(id);
    }

    @PutMapping("/update-status/{maPhieuMuon}")
    public ResponseEntity<MuonTBResponse> updateMuonTBStatus(@PathVariable String maPhieuMuon, @RequestBody MuonTBUpdateStatusRequest updateRequest) {
        MuonTBResponse updatedMuonTB = muonTBService.updateMuonTBStatus(maPhieuMuon, updateRequest);
        return ResponseEntity.ok(updatedMuonTB);
    }

    @PutMapping("/update-info/{maPhieuMuon}")
    public ResponseEntity<MuonTBResponse> updateMuonTBInfo(@PathVariable String maPhieuMuon, @RequestBody MuonTBUpdateRequest updateRequest) {
        MuonTBResponse updatedMuonTB = muonTBService.updateMuonTBInfo(maPhieuMuon, updateRequest);
        return ResponseEntity.ok(updatedMuonTB);
    }

    @GetMapping("/monthly-borrowed")
    public ResponseEntity<List<MonthlyBorrowedDevicesResponse>> getMonthlyBorrowedDevices() {
        List<MonthlyBorrowedDevicesResponse> data = muonTBService.getMonthlyBorrowedDevices();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<MuonTBResponse>> searchByGiaoVien(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam int page,
            @RequestParam int size) {
        return ResponseEntity.ok(muonTBService.searchByGiaoVien(name, page, size));
    }
}
