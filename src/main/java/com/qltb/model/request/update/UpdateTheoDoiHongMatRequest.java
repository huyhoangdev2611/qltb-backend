package com.qltb.model.request.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTheoDoiHongMatRequest {
    private String maPhieuBao;
    private LocalDate ngayBao;
    private String maNguoiBao;
    private String maTB;
    private String maKP;
    private int slHong;
    private int slMat;
    private int slDaSua;
    private String ghiChu;
}
