package com.qltb.model.request.update;

import com.qltb.model.request.create.ChiTietMuonTBCreateRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data

public class MuonTBUpdateRequest {
    private LocalDate ngayMuon;
    private LocalDate ngayHenTra;
    private String maGV;
    private String mucDich;
    private String trangThai;
    private List<ChiTietMuonTBCreateRequest> chiTietMuonTBList;
}
