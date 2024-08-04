package com.qltb.controller;

import com.qltb.model.request.create.TangTBCreateRequest;
import com.qltb.model.request.update.TangTBUpdateRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.service.TangTBService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tang-tb")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TangTBController {
    TangTBService tangTBService;

    @PostMapping("/create")
    public TangTBResponse create(@RequestBody TangTBCreateRequest request) {
        return tangTBService.create(request);
    }

    @GetMapping("/page")
    public Page<TangTBResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return tangTBService.getAll(page, size);
    }

    @PostMapping("/duyet-tang-tb/{maPhieuTang}")
    public TangTBResponse duyetTangTB(@PathVariable String maPhieuTang, @RequestBody TangTBUpdateRequest request) {
        return tangTBService.duyetTangTB(maPhieuTang, request);
    }

    @DeleteMapping("/delete/{maPhieuTang}")
    public void delete(@PathVariable String maPhieuTang) {
        tangTBService.delete(maPhieuTang);
    }

}
