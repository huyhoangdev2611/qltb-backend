package com.qltb_backend.model.request.create;

import lombok.Data;

@Data
public class ChiTietMuonTBCreateRequest {
    private String maPhieuMuon;
    private String maCaBietTB;
    private String tinhTrangKhiMuon;
    private String muonTBId;
}
