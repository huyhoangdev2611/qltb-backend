package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.GiaoVien;
import com.qltb.entity.ThietBi;

import java.util.Date;

@Data
public class TheoDoiHongMatResponse {
    private String maPhieuBao;
    private String maGiaoVien;
    private String maCaBietTB;
    private String khoPhong;
    private String tenTB;
    private boolean isHong;
    private boolean isMat;
    private String lyDoHongMat;
}
