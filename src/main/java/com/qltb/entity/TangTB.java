package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tang_tb")
public class TangTB {
    @Id
    @Column(name = "ma_phieu_tang", length = 10)
    private String maPhieuTang;

    @Column(name = "ngay_lap")
    private Date ngayLap;

    @ManyToOne
    @JoinColumn(name = "ma_nguon_cap")
    private NguonCap nguonCap;

    @Column(name = "noi_dung")
    private String noiDung;

    @OneToMany(mappedBy = "tangTB")
    private List<ChiTietTangTB> chiTietTangTBList;


}
