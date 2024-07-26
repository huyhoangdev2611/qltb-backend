package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.ToCM;

import java.util.Date;

@Data
public class GiaoVienResponse {
    private String maGV;
    private String tenGV;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private ToCM toCM;
}
