package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.DonViTinh;
import com.qltb.entity.MonHoc;
import com.qltb.entity.LoaiTB;

@Data
public class NhomThietBiResponse {
    private String maNTB;
    private String tenNTB;
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
