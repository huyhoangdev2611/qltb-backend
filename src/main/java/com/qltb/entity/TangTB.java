package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tang_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TangTB {
    @Id
    @Column(name = "ma_phieu_tang")
    private String maPhieuTang;

    @Column(name = "ngay_lap")
    private LocalDate ngayLap;

    @Column(name = "ma_nguon_cap")
    private String maNguonCap;

    @Column(name = "noi_dung")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "ma_nguon_cap", insertable = false, updatable = false)
    private NguonCap nguonCap;

    @OneToMany(mappedBy = "tangTB")
    private List<ChiTietTangTB> chiTietTangTBs;
}
