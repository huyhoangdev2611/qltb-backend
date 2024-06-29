package com.qltb.controller;

import com.qltb.entity.ChiTietKiemKeKey;
import com.qltb.model.request.create.CreateChiTietKiemKeRequest;
import com.qltb.model.request.update.UpdateChiTietKiemKeRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import com.qltb.model.response.ChiTietKiemKeResponse;
import com.qltb.service.ChiTietKiemKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chi-tiet-kiem-ke")
public class ChiTietKiemKeController {
    @Autowired
    ChiTietKiemKeService chiTietKiemKeService;

    @PostMapping("/create")
    public ResponseEntity<ChiTietKiemKeResponse> createChiTietKiemKe(CreateChiTietKiemKeRequest request) {
        return ResponseEntity.ok(chiTietKiemKeService.create(request));
    }

    @GetMapping("")
    public ResponseEntity<List<ChiTietKiemKeResponse>> getAllChiTietKiemKe() {
        return ResponseEntity.ok(chiTietKiemKeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietKiemKeResponse> getChiTietKiemKeById(ChiTietKiemKeKey id) {
        return ResponseEntity.ok(chiTietKiemKeService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChiTietKiemKeResponse> updateChiTietKiemKe(ChiTietKiemKeKey id, UpdateChiTietKiemKeRequest request) {
        return ResponseEntity.ok(chiTietKiemKeService.update(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChiTietKiemKe(ChiTietKiemKeKey id) {
        chiTietKiemKeService.delete(id);
    }
}
