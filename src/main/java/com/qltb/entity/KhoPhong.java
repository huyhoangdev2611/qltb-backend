package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "kho_phong")
public class KhoPhong {
    @Id
    @Column(name = "ma_kp", length = 10)
    private String maKP;

    @Column(name = "ten_kp")
    private String tenKP;

    @OneToMany(mappedBy = "khoPhong")
    private List<ThietBi> thietBiList;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietTangTB> chiTietTangTBList;
}
