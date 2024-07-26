package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "thanh_ly_tb")
public class ThanhLyTB {
    @Id
    @Column(name = "ma_phieu_thanh_ly", length = 10)
    private String maPhieuThanhLy;

    @Column(name = "ngay_lap")
    private Date ngayLap;

    @Column(name = "noi_dung")
    private String noiDung;

    @OneToMany(mappedBy = "thanhLyTB")
    private List<ChiTietThanhLyTB> chiTietThanhLyTBList;
}
