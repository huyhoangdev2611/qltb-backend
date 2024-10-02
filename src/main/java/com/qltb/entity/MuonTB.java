package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "muon_tb")
public class MuonTB {
    @Id
    @Column(name = "ma_phieu_muon", length = 10)
    private String maPhieuMuon;

    @Column(name = "ngay_muon")
    private LocalDate ngayMuon;

    @Column(name = "ngay_hen_tra")
    private LocalDate ngayHenTra;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ma_gv")
    private String maGV;

    @ManyToOne
    @JoinColumn(name = "ma_gv", insertable = false, updatable = false)
    private GiaoVien giaoVien;

    @Column(name = "muc_dich")
    private String mucDich;

    @OneToMany(mappedBy = "muonTB")
    private List<ChiTietMuonTB> chiTietMuonTBList;
}
