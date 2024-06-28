package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateChiTietMuonTBRequest {
    private String maPhieuMuon;
    private String maTB;
    private String maKP;
    private int slMuon;
}
