package com.qltb_backend.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class TraTBCreateRequest {
    private String maPhieuTra;
    private Date ngayTra;
    private String maPhieuMuon;
}
