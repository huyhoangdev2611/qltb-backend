package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTangTBRequest {
    private LocalDate ngayLap;
    private String maNguonCap;
    private String noiDung;
    private List<CreateChiTietTangTBRequest> chiTietTangTBs;
}
