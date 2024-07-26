package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "theo_doi_hong_mat")
public class TheoDoiHongMat {
    @Id
    @Column(name = "ma_phieu_bao", length = 10)
    private String maPhieuBao;

    @Column(name = "ngay_bao")
    private Date ngayBao;

    @ManyToOne
    @JoinColumn(name = "ma_nguoi_bao")
    private GiaoVien giaoVien;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb")
    private ThietBi thietBi;

    @Column(name = "is_hong")
    private boolean isHong;

    @Column(name = "is_mat")
    private boolean isMat;

    @Column(name = "ly_do_hong_mat")
    private String lyDoHongMat;
}
