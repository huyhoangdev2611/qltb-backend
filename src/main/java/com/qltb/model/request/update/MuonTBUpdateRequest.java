package com.qltb.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class MuonTBUpdateRequest {
    private Date ngayMuon;
    private Date ngayHenTra;
    private String maGV;
    private String mucDich;
}
