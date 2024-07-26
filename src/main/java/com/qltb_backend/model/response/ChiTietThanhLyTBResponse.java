package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.ThietBi;
import com.qltb_backend.entity.ThanhLyTB;

@Data
public class ChiTietThanhLyTBResponse {
    private String maPhieuThanhLy;
    private ThietBi thietBi;
    private String lyDoTL;
    private ThanhLyTB thanhLyTB;
}
