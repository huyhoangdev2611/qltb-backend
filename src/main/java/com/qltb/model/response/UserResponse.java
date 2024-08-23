package com.qltb.model.response;

import com.qltb.model.response.GiaoVienResponse;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String maGV;
    private String name;
    private String email;
    private GiaoVienResponse giaoVien; // Thông tin giáo viên liên kết
}