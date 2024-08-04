package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThongTinMuonTBCuaGiaoVienResponse {
    private String maNTB;
    private String tenNTB;
    private Long soLuotMuon;
}
