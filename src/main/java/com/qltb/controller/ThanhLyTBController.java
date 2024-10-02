package com.qltb.controller;

import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.request.update.ThanhLyTBUpdateRequest;
import com.qltb.model.response.ThanhLyTBResponse;
import com.qltb.service.ThanhLyTBService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/thanh-ly-tb")
public class ThanhLyTBController {
    ThanhLyTBService thanhLyTBService;

    @PostMapping("/create")
    public ThanhLyTBResponse create(@RequestBody ThanhLyTBCreateRequest request) {
        return thanhLyTBService.create(request);
    }

    @GetMapping("/page")
    public Page<ThanhLyTBResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return thanhLyTBService.getAll(page, size);
    }

    @GetMapping("/search")
    public Page<ThanhLyTBResponse> search(@RequestParam(name = "name") String maPhieuThanhLy, @RequestParam int page, @RequestParam int size) {
        return thanhLyTBService.search(maPhieuThanhLy, page, size);
    }

    @PatchMapping("/huy-thanh-ly-tb/{maCaBietTB}")
    public ResponseEntity huyThanhLyTB(@PathVariable String maCaBietTB) {
        thanhLyTBService.huyThanhLyTB(maCaBietTB);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{maPhieuThanhLy}")
    public ThanhLyTBResponse update(@PathVariable String maPhieuThanhLy, @RequestBody ThanhLyTBUpdateRequest request) {
        return thanhLyTBService.update(maPhieuThanhLy, request);
    }

    @DeleteMapping("/{maPhieuThanhLy}")
    public void delete(@PathVariable String maPhieuThanhLy) {
        thanhLyTBService.delete(maPhieuThanhLy);
    }
}
