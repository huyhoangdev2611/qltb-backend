    package com.qltb.entity;
    
    import jakarta.persistence.*;
    import lombok.Data;
    
    @Data
    @Entity
    @Table(name = "chi_tiet_muon_tb")
    public class ChiTietMuonTB {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
    
        @Column(name = "ma_ca_biet_tb")
        private String maCaBietTB;
    
        @Column(name = "tinh_trang_khi_muon")
        private String tinhTrangKhiMuon;
    
        @Column(name = "ma_phieu_muon")
        private String maPhieuMuon;
    
        @ManyToOne
        @JoinColumn(name = "ma_phieu_muon", insertable = false, updatable = false)
        private MuonTB muonTB;
    
        @ManyToOne
        @JoinColumn(name = "ma_ca_biet_tb", insertable = false, updatable = false)
        private ThietBi thietBi;
    }
