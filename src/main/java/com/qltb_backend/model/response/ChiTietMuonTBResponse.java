package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.ThietBi;
import com.qltb_backend.entity.MuonTB;

@Data
public class ChiTietMuonTBResponse {
    private String maPhieuMuon;
    private ThietBi thietBi;
    private String tinhTrangKhiMuon;
    private MuonTB muonTB;
}
