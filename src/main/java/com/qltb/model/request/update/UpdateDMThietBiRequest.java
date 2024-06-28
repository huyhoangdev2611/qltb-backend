package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDMThietBiRequest {
    private String maTB;
    private String tenTB;
    private String maDVT;
    private String maMonHoc;
    private String maLoaiTB;
    private int slToiThieu;
    private boolean tbTuLam;
    private boolean tbTieuHao;
    private String moTa;
}
