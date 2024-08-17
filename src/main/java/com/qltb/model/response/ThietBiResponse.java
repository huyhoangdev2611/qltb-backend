package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.NhomThietBi;
import com.qltb.entity.KhoPhong;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ThietBiResponse {
    private String maCaBietTB;
    private String maNTB;
    private String tenNTB;
    private String khoPhong;
    private LocalDate ngayNhap;
    private LocalDate hanSuDung;
    private String trangThai;
    private String tinhTrang;
    private boolean thietBiTieuHao;
    private boolean dangHoatDong;
}
