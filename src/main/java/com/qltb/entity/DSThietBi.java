package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "ds_thiet_bi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DSThietBi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ma_tb")
    private String maTB;

    @Column(name = "ma_kp")
    private String maKP;

    @Column(name = "ten_tb")
    private String tenTB;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "trong_kho")
    private int trongKho;

    @Column(name = "hong")
    private int hong;

    @Column(name = "mat")
    private int mat;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;

//    @ManyToMany
//    private Set<KhoPhong> khoPhongs;
}
