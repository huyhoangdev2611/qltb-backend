package com.qltb.model.request.update;

import com.qltb.model.request.create.ChiTietTangTBCreateRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class TangTBUpdateRequest {
    private LocalDate ngayLap;
    private String maNguonCap;
    private String noiDung;
    List<ChiTietTangTBCreateRequest> chiTietTangTBList;
}
