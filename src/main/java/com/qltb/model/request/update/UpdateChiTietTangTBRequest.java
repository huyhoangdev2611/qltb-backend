package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateChiTietTangTBRequest {
    private String maPhieuTang;
    private String maTB;
    private String maKP;
    private int soLuong;
    private int donGia;
}
