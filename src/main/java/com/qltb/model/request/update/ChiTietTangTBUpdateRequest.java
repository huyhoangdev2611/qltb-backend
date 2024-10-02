package com.qltb.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class ChiTietTangTBUpdateRequest {
    private Date hanSuDung;
    private int soLuong;
    private int donGia;
    private String tangTBId;
}
