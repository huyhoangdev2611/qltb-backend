package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateChiTietTangTBRequest {
    private String maPhieuTang;
    private String maTB;
    private String maKP;
    private int soLuong;
    private int donGia;
}
