package com.qltb.controller;

import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.response.ThietBiResponse;
import com.qltb.service.ThietBiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thiet-bi")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThietBiController {
    ThietBiService thietBiService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ThietBiCreateRequest request) {
        thietBiService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page")
    public Page<ThietBiResponse> getTBs(@RequestParam int page, @RequestParam int size) {
        return thietBiService.getTBs(page, size);
    }

    @PatchMapping("/{maCaBietTB}")
    public ResponseEntity updateActivating(@PathVariable String maCaBietTB) {
        thietBiService.updateActivating(maCaBietTB);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<ThietBiResponse> getAll() {
        return thietBiService.getAll();
    }
}
