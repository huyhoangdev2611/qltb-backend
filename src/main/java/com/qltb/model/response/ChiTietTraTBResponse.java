package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.TraTB;

@Data
public class ChiTietTraTBResponse {
    private String maPhieuTra;
    private ThietBi thietBi;
    private String tinhTrangTra;
    private String ghiChu;
    private TraTB traTB;
}
