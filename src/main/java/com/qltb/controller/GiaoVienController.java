package com.qltb.controller;

import com.qltb.model.request.create.GiaoVienCreateRequest;
import com.qltb.model.request.update.GiaoVienUpdateRequest;
import com.qltb.model.request.update.GiaoVienUpdateRequest;
import com.qltb.model.response.GiaoVienResponse;
import com.qltb.service.GiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giao-vien")
public class GiaoVienController {
    @Autowired
    private GiaoVienService giaoVienService;

    @PostMapping("/create")
    public ResponseEntity<GiaoVienResponse> createGiaoVien(@RequestBody GiaoVienCreateRequest request) {
        return ResponseEntity.ok(giaoVienService.create(request));
    }

    @PutMapping("/update/{maGV}")
    public ResponseEntity<GiaoVienResponse> updateGiaoVien(@PathVariable String maGV, @RequestBody GiaoVienUpdateRequest request) {
        return ResponseEntity.ok(giaoVienService.update(maGV, request));
    }

    @DeleteMapping("/delete/{maGV}")
    public void deleteGiaoVien(@PathVariable String maGV) {
        giaoVienService.delete(maGV);
    }

    @GetMapping("/{maGV}")
    public ResponseEntity<GiaoVienResponse> getGiaoVienById(@PathVariable String maGV) {
        return ResponseEntity.ok(giaoVienService.getById(maGV));
    }

    @GetMapping
    public ResponseEntity<List<GiaoVienResponse>> getAllGiaoVien() {
        return ResponseEntity.ok(giaoVienService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<GiaoVienResponse>> getAllGiaoVien(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(giaoVienService.getAll(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<GiaoVienResponse>> searchByName (
            @RequestParam String name, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(giaoVienService.searchByName(name, page, size));
    }
}