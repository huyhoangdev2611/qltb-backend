package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.ThietBi;
import com.qltb_backend.entity.KhoPhong;
import com.qltb_backend.entity.TangTB;

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
