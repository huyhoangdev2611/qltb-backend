package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_tra_tb")
public class ChiTietTraTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_ca_biet_tb")
    private String maCaBietTB;

    @Column(name = "tinh_trang_tra")
    private String tinhTrangTra;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "ma_phieu_tra")
    private String maPhieuTra;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_tra", insertable = false, updatable = false)
    private TraTB traTB;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb", insertable = false, updatable = false)
    private ThietBi thietBi;
}
