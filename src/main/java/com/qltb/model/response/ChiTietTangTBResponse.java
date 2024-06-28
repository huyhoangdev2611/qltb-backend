package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietTangTBResponse {
    private String maPhieuTang;
    private String maTB;
    private String maKP;
    private int soLuong;
    private int donGia;
}
