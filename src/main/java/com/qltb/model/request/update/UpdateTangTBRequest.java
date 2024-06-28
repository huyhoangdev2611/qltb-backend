package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTangTBRequest {
    private String maPhieuTang;
    private LocalDate ngayLap;
    private String maNguonCap;
    private String noiDung;
}
