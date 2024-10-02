package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TKSoLuongTheoNTBResponse {
    private String maNTB;
    private String tenNTB;
    private Long tongSoLuong;
    private Long hong;
    private Long dungDuoc;
}
