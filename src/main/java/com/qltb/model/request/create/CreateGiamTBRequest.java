package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGiamTBRequest {
    private Date ngayLap;
    private String noiDung;
    private String nguonCap;
    private List<CreateChiTietGiamTBRequest> chiTietGiamTBs;
}
