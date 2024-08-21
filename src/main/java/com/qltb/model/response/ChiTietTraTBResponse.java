package com.qltb.model.response;

import lombok.Data;

@Data
public class ChiTietTraTBResponse {
    private String maCaBietTB;
    private String tenNTB;
    private String tinhTrang;
    private String tinhTrangTra;
    private String ghiChu;
    private boolean thietBiTieuHao;
}
