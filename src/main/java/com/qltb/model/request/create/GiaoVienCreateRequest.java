package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class GiaoVienCreateRequest {
    private String tenGV;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String maToCM;
}
