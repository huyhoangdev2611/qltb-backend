package com.qltb.model.request.create;

import lombok.Data;
import java.util.Date;

@Data
public class MuonTBCreateRequest {
    private String maPhieuMuon;
    private Date ngayMuon;
    private Date ngayHenTra;
    private String maGV;
    private String mucDich;
}
