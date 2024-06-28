package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietMuonTBResponse {
    private String maPhieuMuon;
    private String maTB;
    private String maKP;
    private int slMuon;
}
