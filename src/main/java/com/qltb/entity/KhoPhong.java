package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "kho_phong")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhoPhong {
    @Id
    @Column(name = "ma_kp")
    private String maKP;

    @Column(name = "ten_kp")
    private String tenKP;

    @OneToMany(mappedBy = "khoPhong")
    private List<DSThietBi> dsThietBis;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietTangTB> chiTietTangTBs;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietGiamTB> chiTietGiamTBs;

    @OneToMany(mappedBy = "khoPhong")
    private List<TheoDoiHongMat> theoDoiHongMats;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietKiemKe> chiTietKiemKes;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietMuonTB> chiTietMuonTBs;

    @OneToMany(mappedBy = "khoPhong")
    private List<ChiTietTraTB> chiTietTraTBs;
}
