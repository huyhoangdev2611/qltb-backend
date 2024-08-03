package com.qltb.model.response;

import com.qltb.entity.MuonTB;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TraTBResponse {
    private String maPhieuTra;
    private String maPhieuMuon;
    private String tenGiaoVien;
    private LocalDate ngayMuon;
    private LocalDate ngayTra;
    private List<ChiTietTraTBResponse> chiTietTraTBList;
}
