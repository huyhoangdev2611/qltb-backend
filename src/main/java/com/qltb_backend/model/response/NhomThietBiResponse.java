package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.DonViTinh;
import com.qltb_backend.entity.MonHoc;
import com.qltb_backend.entity.LoaiTB;

@Data
public class NhomThietBiResponse {
    private String maNTB;
    private String tenNTB;
    private DonViTinh donViTinh;
    private MonHoc monHoc;
    private LoaiTB loaiTB;
    private int slToiThieu;
    private boolean tbTuLam;
    private boolean tbTieuHao;
    private String moTa;
}
