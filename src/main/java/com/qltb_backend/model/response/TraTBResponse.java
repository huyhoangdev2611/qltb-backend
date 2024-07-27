package com.qltb_backend.model.response;

import lombok.Data;
import com.qltb_backend.entity.MuonTB;

import java.util.Date;

@Data
public class TraTBResponse {
    private String maPhieuTra;
    private Date ngayTra;
    private MuonTB muonTB;
}
