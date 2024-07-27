package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class ThietBiCreateRequest {
    private String maCaBietTB;
    private String maNTB;
    private String maKP;
    private Date ngayNhap;
    private Date hanSuDung;
    private String trangThai;
    private String tinhTrang;
    private boolean dangHoatDong;
}
