package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "chi_tiet_tang_tb")
public class ChiTietTangTB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "ma_kp")
    private String maKP;

    @Column(name = "ma_ntb")
    private String maNTB;

    @ManyToOne
    @JoinColumn(name = "ma_ntb", insertable = false, updatable = false)
    private NhomThietBi nhomThietBi;

    @ManyToOne
    @JoinColumn(name = "ma_kp", insertable = false, updatable = false)
    private KhoPhong khoPhong;

    @Column(name = "han_su_dung")
    private LocalDate hanSuDung;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "don_gia")
    private int donGia;

    @Column(name = "ma_phieu_tang")
    private String maPhieuTang;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_tang", insertable = false, updatable = false)
    private TangTB tangTB;
}
