package com.qltb.model.request.create;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BaoCaoThongKeCreateRequest {
    private String option;
    private LocalDate tuNgay;
    private LocalDate denNgay;
}
