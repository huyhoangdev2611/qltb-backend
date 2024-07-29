package com.qltb.controller;

import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.response.ThanhLyTBResponse;
import com.qltb.service.ThanhLyTBService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/thanh-ly-tb")
public class ThanhLyTBController {
    ThanhLyTBService thanhLyTBService;

    @PostMapping("/create")
    public ThanhLyTBResponse create(@RequestBody ThanhLyTBCreateRequest request) {
        return thanhLyTBService.create(request);
    }
}
