package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_tang_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietTangTB {
    @EmbeddedId
    private ChiTietTangTBKey id;

    @Column(name = "sl_luong")
    private int slLuong;

    @Column(name = "don_gia")
    private int donGia;

    @ManyToOne
    @MapsId("maPhieuTang")
    @JoinColumn(name = "ma_phieu_tang")
    private TangTB tangTB;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;
}
