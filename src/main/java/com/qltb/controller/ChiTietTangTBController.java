package com.qltb.controller;

import com.qltb.entity.ChiTietTangTBKey;
import com.qltb.model.request.update.UpdateChiTietTangTBRequest;
import com.qltb.model.response.ChiTietTangTBResponse;
import com.qltb.service.ChiTietTangTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chi-tiet-tang-tb")
public class ChiTietTangTBController {
    @Autowired
    private ChiTietTangTBService chiTietTangTBService;

    @GetMapping("")
    public List<ChiTietTangTBResponse> getAll() {
        return chiTietTangTBService.getAll();
    }

    @GetMapping("/{maTangTB}")
    public ChiTietTangTBResponse getById(ChiTietTangTBKey maTangTB) {
        return chiTietTangTBService.getById(maTangTB);
    }

    @DeleteMapping("/delete/{maTangTB}")
    public void delete(@PathVariable ChiTietTangTBKey maTangTB) {
        chiTietTangTBService.delete(maTangTB);
    }

    @PutMapping("/update/{maTangTB}")
    public ChiTietTangTBResponse update(@PathVariable ChiTietTangTBKey maTangTB, @RequestBody UpdateChiTietTangTBRequest request) {
        return chiTietTangTBService.update(maTangTB, request);
    }



}
