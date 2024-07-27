package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class ChiTietTangTBCreateRequest {
    private String maPhieuTang;
    private String maTB;
    private String maKP;
    private Date hanSuDung;
    private int soLuong;
    private int donGia;
    private String tangTBId;
}
