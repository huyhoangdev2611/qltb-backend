package com.qltb.model.request.create;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TheoDoiHongMatCreateRequest {
    private LocalDate ngayBao;
    private String maGiaoVien;
    private String maCaBietTB;
    private boolean isHong;
    private boolean isMat;
    private String lyDoHongMat;
}
