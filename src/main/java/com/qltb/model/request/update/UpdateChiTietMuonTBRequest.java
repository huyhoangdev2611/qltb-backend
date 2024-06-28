package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateChiTietMuonTBRequest {
    private String maPhieuMuon;
    private String maTB;
    private String maKP;
    private int slMuon;
}
