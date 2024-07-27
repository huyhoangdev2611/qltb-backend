package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.MuonTB;

@Data
public class ChiTietMuonTBResponse {
    private String maPhieuMuon;
    private ThietBi thietBi;
    private String tinhTrangKhiMuon;
    private MuonTB muonTB;
}
