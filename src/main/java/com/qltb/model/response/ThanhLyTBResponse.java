package com.qltb.model.response;

import com.qltb.entity.ChiTietThanhLyTB;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ThanhLyTBResponse {
    private String maPhieuThanhLy;
    private LocalDate ngayLap;
    private String noiDung;
    private List<ChiTietThanhLyTBResponse> chiTietThanhLyTBList;
}
