package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.MuonTB;

import java.util.Date;

@Data
public class TraTBResponse {
    private String maPhieuTra;
    private Date ngayTra;
    private MuonTB muonTB;
}
