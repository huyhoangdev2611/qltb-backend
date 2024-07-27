package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class TangTBCreateRequest {
    private String maPhieuTang;
    private Date ngayLap;
    private String maNguonCap;
    private String noiDung;
}
