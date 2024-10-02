package com.qltb.model.request.create;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ThietBiCreateRequest {
    private String maNTB;
    private String maKP;
    private LocalDate ngayNhap;
    private LocalDate hanSuDung;
//    private String trangThai;
//    private String tinhTrang;
    private int soLuong;
}
