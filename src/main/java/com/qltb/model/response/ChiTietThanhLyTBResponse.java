package com.qltb.model.response;

import lombok.Data;
import com.qltb.entity.ThietBi;
import com.qltb.entity.ThanhLyTB;

@Data
public class ChiTietThanhLyTBResponse {
    private String maCaBietTB;
    private String tenNTB;
    private String khoPhong;
    private String trangThai;
    private String tinhTrang;
    private String lyDoThanhLy;

}
