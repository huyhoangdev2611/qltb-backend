package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "chi_tiet_tang_tb")
public class ChiTietTangTB {
    @Id
    @Column(name = "ma_phieu_tang", length = 10)
    private String maPhieuTang;

    @ManyToOne
    @JoinColumn(name = "ma_tb")
    private ThietBi thietBi;

    @ManyToOne
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;

    @Column(name = "han_su_dung")
    private Date hanSuDung;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "don_gia")
    private int donGia;

    @ManyToOne
    @JoinColumn(name = "tang_tb_id") // Use the correct column name here
    private TangTB tangTB;
}
