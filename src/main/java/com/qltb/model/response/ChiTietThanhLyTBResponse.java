package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.ThanhLyTB;

@Data
public class ChiTietThanhLyTBResponse {
    private String maPhieuThanhLy;
    private ThietBi thietBi;
    private String lyDoTL;
    private ThanhLyTB thanhLyTB;
}
