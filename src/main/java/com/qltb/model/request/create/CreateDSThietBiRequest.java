package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDSThietBiRequest {
    private String maTB;
    private String maKP;
    private int soLuong;
    private String tenTB;
//    private int trongKho;
//    private int hong;
//    private int mat;
}
