package com.qltb.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class TheoDoiHongMatUpdateRequest {
    private Date ngayBao;
    private String maGiaoVien;
    private String lyDoHongMat;
}
