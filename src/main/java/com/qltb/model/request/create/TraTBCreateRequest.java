package com.qltb.model.request.create;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TraTBCreateRequest {
    private LocalDate ngayTra;
    private String maPhieuMuon;
    private List<ChiTietTraTBCreateRequest> chiTietTraTBList;
}
