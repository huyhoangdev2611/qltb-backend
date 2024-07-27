package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class ThanhLyTBCreateRequest {
    private String maPhieuThanhLy;
    private Date ngayLap;
    private String noiDung;
}
