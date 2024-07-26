package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private Date ngayMuon;

    @Column(name = "ngay_hen_tra")
    private Date ngayHenTra;

    @ManyToOne
    @JoinColumn(name = "ma_gv")
    private GiaoVien giaoVien;

    @Column(name = "muc_dich")
    private String mucDich;

    @OneToMany(mappedBy = "muonTB")
    private List<ChiTietMuonTB> chiTietMuonTBList;
}
