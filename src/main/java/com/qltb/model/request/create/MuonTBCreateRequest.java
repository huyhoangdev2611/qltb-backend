package com.qltb.model.request.create;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class MuonTBCreateRequest {
    private LocalDate ngayMuon;
    private LocalDate ngayHenTra;
    private String maGV;
    private String mucDich;
    private String trangThai;
    private List<ChiTietMuonTBCreateRequest> chiTietMuonTBList;
}
