package com.qltb_backend.model.request.update;

import lombok.Data;
import java.util.Date;

@Data
public class TheoDoiHongMatUpdateRequest {
    private Date ngayBao;
    private String maNguoiBao;
    private String maCaBietTB;
    private boolean isHong;
    private boolean isMat;
    private String lyDoHongMat;
}
