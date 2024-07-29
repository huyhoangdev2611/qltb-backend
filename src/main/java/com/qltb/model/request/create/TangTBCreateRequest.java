package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class TangTBCreateRequest {
    private Date ngayLap;
    private String maNguonCap;
    private String noiDung;
    List<ChiTietTangTBCreateRequest> chiTietTangTBList;
}
