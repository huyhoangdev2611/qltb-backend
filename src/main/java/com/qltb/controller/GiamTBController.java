package com.qltb.controller;

import com.qltb.model.request.create.CreateGiamTBRequest;
import com.qltb.model.request.update.UpdateGiamTBRequest;
import com.qltb.model.response.GiamTBResponse;
import com.qltb.service.GiamTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giam-tb")
public class GiamTBController {
    @Autowired
    private GiamTBService giamTBService;

    @GetMapping("")
    public List<GiamTBResponse> getAllGiamTB() {
        return giamTBService.getGiamTBs();
    }

    @GetMapping("/{id}")
    public GiamTBResponse getGiamTBById(String id) {
        return giamTBService.getById(id);
    }

    @PostMapping("/create")
    public GiamTBResponse createGiamTB(CreateGiamTBRequest request) {
        return giamTBService.createGiamTB(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGiamTB(@PathVariable String id) {
        giamTBService.deleteGiamTB(id);
    }

    @PutMapping("/update/{id}")
    public GiamTBResponse updateGiamTB(@PathVariable String id, UpdateGiamTBRequest request) {
        return giamTBService.updateGiamTB(id, request);
    }
}
