package com.qltb_backend.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class ThietBiUpdateRequest {
    private String maNTB;
    private String maKP;
    private Date ngayNhap;
    private Date hanSuDung;
    private String trangThai;
    private String tinhTrang;
    private boolean dangHoatDong;
}
