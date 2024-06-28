package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietTraTBResponse {
    private String maPhieuTra;
    private String maTB;
    private String maKP;
    private int slTra;
    private int slHong;
    private int slMat;
    private int slTieuHao;
}
