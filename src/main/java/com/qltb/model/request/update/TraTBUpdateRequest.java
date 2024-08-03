package com.qltb.model.request.update;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TraTBUpdateRequest {
    private LocalDate ngayTra;
    private String maPhieuMuon;
    private List<ChiTietTraTBUpdateRequest> chiTietTraTBList;
}
