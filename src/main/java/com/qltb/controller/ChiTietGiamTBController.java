package com.qltb.controller;

import com.qltb.model.request.create.CreateChiTietGiamTBRequest;
import com.qltb.model.request.update.UpdateChiTietGiamTBRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import com.qltb.service.ChiTietGiamTBService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chi-tiet-giam-tb")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChiTietGiamTBController {

    ChiTietGiamTBService chiTietGiamTBService;

    @PostMapping("/create")
    public ResponseEntity<ChiTietGiamTBResponse> createChiTietGiamTB(@RequestBody CreateChiTietGiamTBRequest request) {
        ChiTietGiamTBResponse response = chiTietGiamTBService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietGiamTBResponse> getChiTietGiamTBById(@PathVariable String id) {
        ChiTietGiamTBResponse response = chiTietGiamTBService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    public ResponseEntity<List<ChiTietGiamTBResponse>> getAllChiTietGiamTB() {
        List<ChiTietGiamTBResponse> response = chiTietGiamTBService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChiTietGiamTB(@PathVariable String id) {
        chiTietGiamTBService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChiTietGiamTBResponse> updateChiTietGiamTB(@PathVariable String id, @RequestBody UpdateChiTietGiamTBRequest request) {
        ChiTietGiamTBResponse response = chiTietGiamTBService.update(id, request);
        return ResponseEntity.ok(response);
    }
}
