package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TKThanhLyResponse {
    private String maCaBietTB;
    private String tenTB;
    private LocalDate ngayThanhLy;
    private String lyDoThanhLy;
}
