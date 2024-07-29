package com.qltb.model.response;

import com.qltb.entity.ChiTietTangTB;
import lombok.Data;
import com.qltb.entity.NguonCap;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class TangTBResponse {
    private String maPhieuTang;
    private LocalDate ngayLap;
    private String nguonCap;
    private String noiDung;
}
