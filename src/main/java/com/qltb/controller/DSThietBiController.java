package com.qltb.controller;

import com.qltb.model.request.create.CreateDSThietBiRequest;
import com.qltb.model.response.DSThietBiResponse;
import com.qltb.model.response.KhoPhongResponse;
import com.qltb.service.DSThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ds-thiet-bi")
public class DSThietBiController {
    @Autowired
    private DSThietBiService dsThietBiService;

    @PostMapping("/create")
    public ResponseEntity<DSThietBiResponse> createDSThietBi(@RequestBody CreateDSThietBiRequest request) throws Exception {
        return ResponseEntity.ok(dsThietBiService.create(request));
    }

    @GetMapping("")
    public ResponseEntity<List<DSThietBiResponse>> getAll() {
        return ResponseEntity.ok(dsThietBiService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DSThietBiResponse>> getDSThietBi(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dsThietBiService.getDSThietBi(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DSThietBiResponse>> search(@RequestParam String name, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(dsThietBiService.search(name, page, size));
    }

    @GetMapping("/distinct")
    public ResponseEntity<List<DSThietBiResponse>> getDistinctDSThietBi() {
        return ResponseEntity.ok(dsThietBiService.getDistinctByMaTB());
    }

    @GetMapping("/kho-phong/{maTB}")
    public ResponseEntity<List<KhoPhongResponse>> getKhoPhongByMaTB(@PathVariable String maTB) {
        return ResponseEntity.ok(dsThietBiService.findKhoPhongByMaTB(maTB));
    }

    @GetMapping("/get-by-ma-tb-ma-kp")
    public ResponseEntity<DSThietBiResponse> getByMaTBAndMaKP(@RequestParam String maTB, @RequestParam String maKP) {
        return ResponseEntity.ok(dsThietBiService.findByMaTBAndMaKP(maTB, maKP));
    }
}
