package com.qltb_backend.model.request.create;

import lombok.Data;

@Data
public class ChiTietTraTBCreateRequest {
    private String maPhieuTra;
    private String maCaBietTB;
    private String tinhTrangTra;
    private String ghiChu;
    private String traTBId;
}
