package com.qltb.model.request.create;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ThanhLyTBCreateRequest {
    private String maPhieuThanhLy;
    private LocalDate ngayLap;
    private String noiDung;
    private List<ChiTietThanhLyTBCreateRequest> chiTietThanhLyTBList;
}
