package com.qltb_backend.model.request.create;

import lombok.Data;

@Data
public class ChiTietThanhLyTBCreateRequest {
    private String maPhieuThanhLy;
    private String maCaBietTB;
    private String lyDoTL;
    private String thanhLyTBId;
}
