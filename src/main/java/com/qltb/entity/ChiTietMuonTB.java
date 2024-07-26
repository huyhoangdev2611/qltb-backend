package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_muon_tb")
public class ChiTietMuonTB {
    @Id
    @Column(name = "ma_phieu_muon", length = 10)
    private String maPhieuMuon;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb")
    private ThietBi thietBi;

    @Column(name = "tinh_trang_khi_muon")
    private String tinhTrangKhiMuon;

    @ManyToOne
    @JoinColumn(name = "muon_tb_id") // Use the correct column name here
    private MuonTB muonTB;
}
