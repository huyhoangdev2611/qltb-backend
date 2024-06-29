package com.qltb.controller;

import com.qltb.model.request.create.CreateMuonTBRequest;
import com.qltb.model.request.update.UpdateMuonTBRequest;
import com.qltb.model.response.MuonTBResponse;
import com.qltb.service.MuonTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muon-tb")
public class MuonTBController {
    @Autowired
    private MuonTBService muonTBService;

    @GetMapping("")
    public List<MuonTBResponse> getAllMuonTB() {
        return muonTBService.getMuonTBs();
    }

    @PostMapping("/create")
    public MuonTBResponse createMuonTB(CreateMuonTBRequest request) {
        return muonTBService.createMuonTB(request);
    }

    @PutMapping("/update/{id}")
    public MuonTBResponse updateMuonTB(@PathVariable String id, UpdateMuonTBRequest request) {
        return muonTBService.updateMuonTB(id, request);
    }

    @GetMapping("/{id}")
    public MuonTBResponse getMuonTBById(@PathVariable String id) {
        return muonTBService.getById(id);
    }

}
