package com.qltb.controller;

import com.qltb.mapper.DMThietBiMapper;
import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import com.qltb.service.DMThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dm-thiet-bi")
public class DMThietBiController {

    @Autowired
    private DMThietBiService dmThietBiService;

    @PostMapping("/create")
    public ResponseEntity<DMThietBiResponse> createDMThietBi(@RequestBody CreateDMThietBiRequest request) {
        return ResponseEntity.ok(dmThietBiService.create(request));
    }

    @PutMapping("/update/{maTB}")
    public ResponseEntity<DMThietBiResponse> updateDMThietBi(@PathVariable String maTB, @RequestBody UpdateDMThietBiRequest request) {
        return ResponseEntity.ok(dmThietBiService.update(maTB, request));
    }

    @DeleteMapping("/delete/{maTB}")
    public ResponseEntity<Void> deleteDMThietBi(@PathVariable String maTB) {
        dmThietBiService.delete(maTB);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{maTB}")
    public ResponseEntity<DMThietBiResponse> getDMThietBiById(@PathVariable String maTB) {
        return ResponseEntity.ok(dmThietBiService.getById(maTB));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DMThietBiResponse>> getAllDMThietBi(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dmThietBiService.getAll(page, size));
    }

    @GetMapping("")
    public ResponseEntity<List<DMThietBiResponse>> getAllDMThietBi() {
        return ResponseEntity.ok(dmThietBiService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DMThietBiResponse>> searchByName(@RequestParam String name,@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dmThietBiService.searchByName(name, page, size));
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<DMThietBiResponse>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(dmThietBiService.searchByName(name));
    }

    @GetMapping("/get-in-ds-thiet-bi")
    public ResponseEntity<List<DMThietBiResponse>> getInDSThietBi() {
        return ResponseEntity.ok(dmThietBiService.getInDSThietbi());
    }
}
