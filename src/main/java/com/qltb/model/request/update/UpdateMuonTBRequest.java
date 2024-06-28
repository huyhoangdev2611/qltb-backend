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
public class UpdateMuonTBRequest {
    private String maPhieuMuon;
    private LocalDate ngayMuon;
    private LocalDate ngayHenTra;
    private String maGV;
    private String maMonHoc;
    private String maLop;
    private String mucDich;
}
