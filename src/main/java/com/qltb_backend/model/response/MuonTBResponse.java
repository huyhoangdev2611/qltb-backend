package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.GiaoVien;

import java.util.Date;

@Data
public class MuonTBResponse {
    private String maPhieuMuon;
    private Date ngayMuon;
    private Date ngayHenTra;
    private GiaoVien giaoVien;
    private String mucDich;
}
