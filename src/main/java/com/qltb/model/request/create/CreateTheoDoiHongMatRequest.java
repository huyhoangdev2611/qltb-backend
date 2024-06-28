package com.qltb.model.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTheoDoiHongMatRequest {
    private LocalDate ngayBao;
    private String maNguoiBao;
    private String maTB;
    private String maKP;
    private int slHong;
    private int slMat;
    private int slDaSua;
    private String ghiChu;
}
