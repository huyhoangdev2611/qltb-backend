package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.NguonCap;

import java.util.Date;

@Data
public class TangTBResponse {
    private String maPhieuTang;
    private Date ngayLap;
    private NguonCap nguonCap;
    private String noiDung;
}
