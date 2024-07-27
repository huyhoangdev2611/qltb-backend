package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.NhomThietBi;
import com.qltb.entity.KhoPhong;

import java.util.Date;

@Data
public class ThietBiResponse {
    private String maCaBietTB;
    private NhomThietBi nhomThietBi;
    private KhoPhong khoPhong;
    private Date ngayNhap;
    private Date hanSuDung;
    private String trangThai;
    private String tinhTrang;
    private boolean dangHoatDong;
}
