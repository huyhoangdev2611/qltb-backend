package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ds_thiet_bi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DSThietBi {
    @EmbeddedId
    private DSThietBiKey id;

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
}
