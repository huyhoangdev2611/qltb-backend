package com.qltb.controller;

import com.qltb.model.request.create.TraTBCreateRequest;
import com.qltb.model.response.TraTBResponse;
import com.qltb.service.TraTBService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tra-tb")
@RequiredArgsConstructor
public class TraTBController {
    private final TraTBService traTBService;

    @PostMapping("/create")
    public TraTBResponse create(@RequestBody TraTBCreateRequest request) {
        return traTBService.create(request);
    }

    @GetMapping
    public List<TraTBResponse> getAll() {
        return traTBService.findAll();
    }

    @GetMapping("/page")
    public Page<TraTBResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return traTBService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public TraTBResponse findById(@PathVariable String id) {
        return traTBService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        traTBService.delete(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<TraTBResponse>> searchByMuonTB(
            @RequestParam String tenGV, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(traTBService.searchByMuonTB(tenGV, page, size));
    }
}
