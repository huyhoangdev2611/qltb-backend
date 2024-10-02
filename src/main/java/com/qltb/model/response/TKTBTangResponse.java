package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TKTBTangResponse {
    private String tenNTB;
    private String donViTinh;
    private Long tongSoLuongTang;
    private Long tongGiaTri;
}
