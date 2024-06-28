package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateChiTietGiamTBRequest {
    private String maPhieuGiam;
    private String maTB;
    private String maKP;
    private int slHong;
    private int slMat;
    private int slConDungDuoc;
}
