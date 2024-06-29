package com.qltb.controller;

import com.qltb.model.request.create.CreateKiemKeRequest;
import com.qltb.model.request.update.UpdateKiemKeRequest;
import com.qltb.model.response.KiemKeResponse;
import com.qltb.service.KiemKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kiem-ke")
public class KiemKeController {
    @Autowired
    private KiemKeService kiemKeService;

    @GetMapping("")
    public List<KiemKeResponse> getAllKiemKe() {
        return kiemKeService.getKiemKes();
    }

    @GetMapping("/{id}")
    public KiemKeResponse getKiemKeById(String id) {
        return kiemKeService.getById(id);
    }

    @PostMapping("/create")
    public KiemKeResponse createKiemKe(CreateKiemKeRequest request) {
        return kiemKeService.createKiemKe(request);
    }

    @PutMapping("/update/{id}")
    public KiemKeResponse updateKiemKe(@PathVariable String id, UpdateKiemKeRequest request) {
        return kiemKeService.updateKiemKe(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKiemKe(@PathVariable String id) {
        kiemKeService.deleteKiemKe(id);
    }
}
