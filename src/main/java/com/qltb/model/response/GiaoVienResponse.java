package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ToCM;

import java.time.LocalDate;
import java.util.Date;

@Data
public class GiaoVienResponse {
    private String maGV;
    private String tenGV;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String toCM;
    private String maToCM;
}
