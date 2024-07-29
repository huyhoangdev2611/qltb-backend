package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_thanh_ly_tb")
public class ChiTietThanhLyTB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ma_phieu_thanh_ly")
    private String maPhieuThanhLy;

    @Column(name = "ma_ca_biet_tb")
    private String maCaBietTB;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb", insertable = false, updatable = false)
    private ThietBi thietBi;

    @Column(name = "ly_do_tl")
    private String lyDoTL;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_thanh_ly", insertable = false, updatable = false) // Use the correct column name here
    private ThanhLyTB thanhLyTB;
}
