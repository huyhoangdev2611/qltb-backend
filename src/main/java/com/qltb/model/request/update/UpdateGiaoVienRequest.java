package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGiaoVienRequest {
    private String tenGV;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String maToCM;
}
