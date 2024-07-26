package com.qltb_backend.model.request.update;

import lombok.Data;

@Data
public class NhomThietBiUpdateRequest {
    private String tenNTB;
    private String maDVT;
    private String maMonHoc;
    private String maLoaiTB;
    private int slToiThieu;
    private boolean tbTuLam;
    private boolean tbTieuHao;
    private String moTa;
}
