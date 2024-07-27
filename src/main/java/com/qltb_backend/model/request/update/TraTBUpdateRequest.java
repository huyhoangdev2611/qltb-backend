package com.qltb_backend.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class TraTBUpdateRequest {
    private Date ngayTra;
    private String maPhieuMuon;
}
