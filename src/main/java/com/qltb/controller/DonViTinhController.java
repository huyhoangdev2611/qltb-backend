package com.qltb.controller;

import com.qltb.model.request.create.CreateDonViTinhRequest;
import com.qltb.model.response.DonViTinhResponse;
import com.qltb.service.DonViTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/don-vi-tinh")
public class DonViTinhController {
    @Autowired
    private DonViTinhService donViTinhService;

    @GetMapping("")
    public List<DonViTinhResponse> getAll() {
        return donViTinhService.getAll();
    }

    @PostMapping("/create")
    public DonViTinhResponse create(@RequestBody CreateDonViTinhRequest request) {
        return donViTinhService.create(request);
    }
}
