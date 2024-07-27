package com.qltb.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class ThanhLyTBResponse {
    private String maPhieuThanhLy;
    private Date ngayLap;
    private String noiDung;
}
