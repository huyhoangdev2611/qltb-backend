package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietKiemKeResponse {
    private String maKiemKe;
    private String maTB;
    private String maKP;
    private int slHong;
    private int slMat;
    private int slConDungDuoc;
}
