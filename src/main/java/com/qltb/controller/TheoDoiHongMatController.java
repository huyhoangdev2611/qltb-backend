package com.qltb.controller;

import com.qltb.model.request.create.TheoDoiHongMatCreateRequest;
import com.qltb.model.response.TheoDoiHongMatResponse;
import com.qltb.service.TheoDoiHongMatService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theo-doi-hong-mat")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheoDoiHongMatController {
    TheoDoiHongMatService theoDoiHongMatService;

    @PostMapping("/create")
    public TheoDoiHongMatResponse create(@RequestBody TheoDoiHongMatCreateRequest request) {
        return theoDoiHongMatService.create(request);
    }

    @GetMapping("/page")
    public Page<TheoDoiHongMatResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return theoDoiHongMatService.getAll(page, size);
    }
}
