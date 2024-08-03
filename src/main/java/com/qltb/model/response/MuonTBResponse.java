package com.qltb.model.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class MuonTBResponse {
    private String maPhieuMuon;
    private LocalDate ngayMuon;
    private LocalDate ngayHenTra;
    private String giaoVien;
    private String mucDich;
    private String trangThai;
    private List<ChiTietMuonTBResponse> chiTietMuonTBList;
}
