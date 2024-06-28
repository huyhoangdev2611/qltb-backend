package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DSThietBiResponse {
    private String maTB;
    private String maKP;
    private int soLuong;
    private int trongKho;
    private int hong;
    private int mat;
}
