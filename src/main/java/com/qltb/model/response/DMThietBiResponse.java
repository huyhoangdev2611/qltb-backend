package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DMThietBiResponse {
    private String maTB;
    private String tenTB;
    private String maLoaiTB;
    private String maDVT;
    private String donViTinh;
    private String maMonHoc;
    private String tenMonHoc;
    private String loaiTB;
    private int slToiThieu;
    private boolean tbTuLam;
    private boolean tbTieuHao;
    private String moTa;
}
