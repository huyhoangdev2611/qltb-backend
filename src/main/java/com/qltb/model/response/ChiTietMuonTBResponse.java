package com.qltb.model.response;

import lombok.Data;

@Data
public class ChiTietMuonTBResponse {
    private String maCaBietTB;
    private String tenThietBi;
    private String tinhTrangKhiMuon;
    private String maPhieuMuon;
    private boolean thietBiTieuHao;
}
