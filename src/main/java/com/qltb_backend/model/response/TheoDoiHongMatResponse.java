package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.GiaoVien;
import com.qltb_backend.entity.ThietBi;

import java.util.Date;

@Data
public class TheoDoiHongMatResponse {
    private String maPhieuBao;
    private Date ngayBao;
    private GiaoVien giaoVien;
    private ThietBi thietBi;
    private boolean isHong;
    private boolean isMat;
    private String lyDoHongMat;
}
