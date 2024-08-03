package com.qltb.controller;

import com.qltb.model.request.create.ThietBiCreateRequest;
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
}
