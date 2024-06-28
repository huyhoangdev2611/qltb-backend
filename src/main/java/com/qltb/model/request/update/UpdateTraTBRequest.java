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
public class UpdateTraTBRequest {
    private String maPhieuTra;
    private LocalDate ngayTra;
    private String maPhieuMuon;
}
