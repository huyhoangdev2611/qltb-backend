package com.qltb_backend.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class ThanhLyTBCreateRequest {
    private String maPhieuThanhLy;
    private Date ngayLap;
    private String noiDung;
}
