package com.qltb.controller;

import com.qltb.model.request.create.CreateGiaoVienRequest;
import com.qltb.model.request.update.UpdateGiaoVienRequest;
import com.qltb.model.response.GiaoVienResponse;
import com.qltb.service.GiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giao-vien")
public class GiaoVienController {
    @Autowired
    private GiaoVienService giaoVienService;

    @PostMapping("/create")
    public ResponseEntity<GiaoVienResponse> createGiaoVien(@RequestBody CreateGiaoVienRequest request) {
        return ResponseEntity.ok(giaoVienService.create(request));
    }

    @PutMapping("/{maGV}")
    public ResponseEntity<GiaoVienResponse> updateGiaoVien(@PathVariable String maGV, @RequestBody UpdateGiaoVienRequest request) {
        return ResponseEntity.ok(giaoVienService.update(maGV, request));
    }

    @DeleteMapping("/{maGV}")
    public ResponseEntity<Void> deleteGiaoVien(@PathVariable String maGV) {
        giaoVienService.delete(maGV);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{maGV}")
    public ResponseEntity<GiaoVienResponse> getGiaoVienById(@PathVariable String maGV) {
        return ResponseEntity.ok(giaoVienService.getById(maGV));
    }

    @GetMapping
    public ResponseEntity<List<GiaoVienResponse>> getAllGiaoVien() {
        return ResponseEntity.ok(giaoVienService.getAll());
    }
}
