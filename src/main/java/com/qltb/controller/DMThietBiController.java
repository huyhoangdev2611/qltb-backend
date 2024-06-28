package com.qltb.controller;

import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import com.qltb.service.DMThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dm-thiet-bi")
public class DMThietBiController {
    @Autowired
    private DMThietBiService dmThietBiService;

    @PostMapping
    public ResponseEntity<DMThietBiResponse> createDMThietBi(@RequestBody CreateDMThietBiRequest request) {
        return ResponseEntity.ok(dmThietBiService.create(request));
    }

    @PutMapping("/{maTB}")
    public ResponseEntity<DMThietBiResponse> updateDMThietBi(@PathVariable String maTB, @RequestBody UpdateDMThietBiRequest request) {
        return ResponseEntity.ok(dmThietBiService.update(maTB, request));
    }

    @DeleteMapping("/{maTB}")
    public ResponseEntity<Void> deleteDMThietBi(@PathVariable String maTB) {
        dmThietBiService.delete(maTB);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{maTB}")
    public ResponseEntity<DMThietBiResponse> getDMThietBiById(@PathVariable String maTB) {
        return ResponseEntity.ok(dmThietBiService.getById(maTB));
    }

    @GetMapping
    public ResponseEntity<List<DMThietBiResponse>> getAllDMThietBi() {
        return ResponseEntity.ok(dmThietBiService.getAll());
    }
}
