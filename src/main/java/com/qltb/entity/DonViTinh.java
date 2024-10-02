package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "don_vi_tinh")
public class DonViTinh {
    @Id
    @Column(name = "ma_dvt", length = 10)
    private String maDVT;

    @Column(name = "ten_dvt")
    private String tenDVT;

    @OneToMany(mappedBy = "donViTinh")
    private List<NhomThietBi> nhomThietBiList;
}
