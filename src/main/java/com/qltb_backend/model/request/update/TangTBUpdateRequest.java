package com.qltb_backend.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class TangTBUpdateRequest {
    private Date ngayLap;
    private String maNguonCap;
    private String noiDung;
}
