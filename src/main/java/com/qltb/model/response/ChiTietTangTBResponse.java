package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.KhoPhong;
import com.qltb.entity.TangTB;

import java.util.Date;

@Data
public class ChiTietTangTBResponse {
    private String maPhieuTang;
    private ThietBi thietBi;
    private KhoPhong khoPhong;
    private Date hanSuDung;
    private int soLuong;
    private int donGia;
    private TangTB tangTB;
}
