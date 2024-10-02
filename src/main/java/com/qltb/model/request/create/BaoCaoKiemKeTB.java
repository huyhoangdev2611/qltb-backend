package com.qltb.model.request.create;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaoCaoKiemKeTB {
    boolean dangHoatDong;
    boolean dungDuoc;
    boolean hong;
    boolean mat;
    LocalDate tuNgay;
    LocalDate denNgay;
}



