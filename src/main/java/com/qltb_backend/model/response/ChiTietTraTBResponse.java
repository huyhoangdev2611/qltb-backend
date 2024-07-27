package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.ThietBi;
import com.qltb_backend.entity.TraTB;

@Data
public class ChiTietTraTBResponse {
    private String maPhieuTra;
    private ThietBi thietBi;
    private String tinhTrangTra;
    private String ghiChu;
    private TraTB traTB;
}
