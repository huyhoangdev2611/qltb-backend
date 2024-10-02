package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TKSoLuongHongMatTieuHaoResponse {
    String tenNTB;
    Long soLuongMat;
    Long soLuongHong;
    Long soThietBiTieuHao;
}
