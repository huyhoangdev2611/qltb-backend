package com.qltb.controller;

import com.qltb.model.request.create.CreateTangTBRequest;
import com.qltb.model.request.update.UpdateTangTBRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.service.TangTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tang-tb")
public class TangTBController {
    @Autowired
    private TangTBService tangTBService;

    @GetMapping("")
    public List<TangTBResponse> getAllTangTB() {
        return tangTBService.getTangTBs();
    }

    @GetMapping("/{id}")
    public TangTBResponse getTangTBById(String id) {
        return tangTBService.getById(id);
    }

    @PostMapping("/create")
    public TangTBResponse createTangTB(CreateTangTBRequest request) {
        return tangTBService.createTangTB(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTangTB(@PathVariable String id) {
        tangTBService.deleteTangTB(id);
    }

    @PutMapping("/update/{id}")
    public TangTBResponse updateTangTB(@PathVariable String id, UpdateTangTBRequest request) {
        return tangTBService.updateTangTB(id, request);
    }

}
