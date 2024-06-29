package com.qltb.controller;

import com.qltb.model.request.create.CreateTraTBRequest;
import com.qltb.model.request.update.UpdateTraTBRequest;
import com.qltb.model.response.TraTBResponse;
import com.qltb.service.TraTBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tra-tb")
public class TraTBController {
    @Autowired
    private TraTBService traTBService;

    @GetMapping("")
    public List<TraTBResponse> getAllTraTB() {
        return traTBService.getTraTBs();
    }

    @PostMapping("/create")
    public TraTBResponse createTraTB(CreateTraTBRequest request) {
        return traTBService.createTraTB(request);
    }

    @PutMapping("/update/{id}")
    public void updateTraTB(@PathVariable String id, UpdateTraTBRequest request) {
        try {
            traTBService.updateTraTB(id, request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTraTB(@PathVariable String id) {
        traTBService.deleteTraTB(id);
    }
}
