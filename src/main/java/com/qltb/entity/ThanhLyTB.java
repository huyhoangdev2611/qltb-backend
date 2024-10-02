package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate ngayLap;

    @Column(name = "noi_dung")
    private String noiDung;

    @OneToMany(mappedBy = "thanhLyTB", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietThanhLyTB> chiTietThanhLyTBList;
}
