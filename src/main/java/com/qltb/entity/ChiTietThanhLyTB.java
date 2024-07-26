package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_thanh_ly_tb")
public class ChiTietThanhLyTB {
    @Id
    @Column(name = "ma_phieu_thanh_ly", length = 10)
    private String maPhieuThanhLy;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb")
    private ThietBi thietBi;

    @Column(name = "ly_do_tl")
    private String lyDoTL;

    @ManyToOne
    @JoinColumn(name = "thanh_ly_tb_id") // Use the correct column name here
    private ThanhLyTB thanhLyTB;
}
