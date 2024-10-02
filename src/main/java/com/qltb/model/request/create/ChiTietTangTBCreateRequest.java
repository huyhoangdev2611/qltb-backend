package com.qltb.model.request.create;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ChiTietTangTBCreateRequest {
    private String maPhieuTang;
    private String maNTB;
    private String maKP;
    private LocalDate hanSuDung;
    private LocalDate ngayNhap;
    private int soLuong;
    private int donGia;
    private String tangTBId;
}
