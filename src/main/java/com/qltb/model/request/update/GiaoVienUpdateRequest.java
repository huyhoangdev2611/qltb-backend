package com.qltb.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class GiaoVienUpdateRequest {
    private String tenGV;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String maToCM;
}
