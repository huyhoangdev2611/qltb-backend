package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TKTinhHinhMuonTBCuaGVResponse {
    private String tenGV;
    private List<ThongTinMuonTBCuaGiaoVienResponse> thongTins;

    public TKTinhHinhMuonTBCuaGVResponse(String tenGV) {
        this.tenGV = tenGV;
    }
}
