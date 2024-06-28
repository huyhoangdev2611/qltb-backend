package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "theo_doi_hong_mat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheoDoiHongMat {
    @Id
    @Column(name = "ma_phieu_bao")
    private String maPhieuBao;

    @Column(name = "ngay_bao")
    private LocalDate ngayBao;

    @Column(name = "ma_nguoi_bao")
    private String maNguoiBao;

    @Column(name = "ma_tb")
    private String maTB;

    @Column(name = "ma_kp")
    private String maKP;

    @Column(name = "sl_hong")
    private int slHong;

    @Column(name = "sl_mat")
    private int slMat;

    @Column(name = "sl_da_sua")
    private int slDaSua;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "ma_nguoi_bao", insertable = false, updatable = false)
    private GiaoVien giaoVien;

    @ManyToOne
    @JoinColumn(name = "ma_tb", insertable = false, updatable = false)
    private DMThietBi dmThietBi;

    @ManyToOne
    @JoinColumn(name = "ma_kp", insertable = false, updatable = false)
    private KhoPhong khoPhong;
}
