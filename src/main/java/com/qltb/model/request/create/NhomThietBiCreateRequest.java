package com.qltb.model.request.create;

import lombok.Data;

@Data
public class NhomThietBiCreateRequest {
    private String maNTB;
    private String tenNTB;
    private String maDVT;
    private String maMonHoc;
    private String maLoaiTB;
    private int slToiThieu;
    private boolean tbTuLam;
    private boolean tbTieuHao;
    private String moTa;
}
