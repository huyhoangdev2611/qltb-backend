package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.KhoPhong;
import com.qltb.entity.TangTB;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ChiTietTangTBResponse {
    private String maNTB;
    private String tenNTB;
    private String maKP;
    private LocalDate hanSuDung;
    private int soLuong;
    private int donGia;
    private String thanhTienString;
}
