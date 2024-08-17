package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TKThietBiDangMuonResponse {
    String maCaBietTB;
    String tenTB;
    String nguoiMuon;
    LocalDate ngayMuon;
    LocalDate ngayHenTra;
    String quaHan;

    public TKThietBiDangMuonResponse(String maCaBietTB, String tenTB, String nguoiMuon, LocalDate ngayMuon, LocalDate ngayHenTra) {
        this.maCaBietTB = maCaBietTB;
        this.tenTB = tenTB;
        this.nguoiMuon = nguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
//        this.quaHan = ChronoUnit.DAYS.between(ngayHenTra, LocalDate.now()) + " ngày";
    }
}
