package com.qltb_backend.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class GiaoVienCreateRequest {
    private String maGV;
    private String tenGV;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String maToCM;
}
