package com.qltb.controller;

//import com.qltb.mapper.DMThietBiMapper;
import com.qltb.model.request.create.NhomThietBiCreateRequest;
import com.qltb.model.request.update.NhomThietBiUpdateRequest;
import com.qltb.model.response.NhomThietBiResponse;
import com.qltb.service.NhomThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dm-thiet-bi")
public class NhomThietBiController {

    @Autowired
    private NhomThietBiService dmThietBiService;

    @PostMapping("/create")
    public ResponseEntity<NhomThietBiResponse> createDMThietBi(@RequestBody NhomThietBiCreateRequest request) {
        return ResponseEntity.ok(dmThietBiService.create(request));
    }

    @PutMapping("/update/{maTB}")
    public ResponseEntity<NhomThietBiResponse> updateDMThietBi(@PathVariable String maTB, @RequestBody NhomThietBiUpdateRequest request) {
        return ResponseEntity.ok(dmThietBiService.update(maTB, request));
    }

    @DeleteMapping("/delete/{maTB}")
    public void deleteDMThietBi(@PathVariable String maTB) {
        dmThietBiService.delete(maTB);
    }

    @GetMapping("/{maTB}")
    public ResponseEntity<NhomThietBiResponse> getDMThietBiById(@PathVariable String maTB) {
        return ResponseEntity.ok(dmThietBiService.getById(maTB));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<NhomThietBiResponse>> getAllDMThietBi(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dmThietBiService.getAll(page, size));
    }

    @GetMapping("")
    public ResponseEntity<List<NhomThietBiResponse>> getAllDMThietBi() {
        return ResponseEntity.ok(dmThietBiService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<Page<NhomThietBiResponse>> searchByName(@RequestParam String name,@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dmThietBiService.searchByName(name, page, size));
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<NhomThietBiResponse>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(dmThietBiService.searchByName(name));
    }

//    @GetMapping("/get-in-ds-thiet-bi")
//    public ResponseEntity<List<NhomThietBiResponse>> getInDSThietBi() {
//        return ResponseEntity.ok(dmThietBiService.getInDSThietbi());
//    }
}