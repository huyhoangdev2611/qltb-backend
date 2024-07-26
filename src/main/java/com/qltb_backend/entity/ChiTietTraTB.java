package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_tra_tb")
public class ChiTietTraTB {
    @Id
    @Column(name = "ma_phieu_tra", length = 10)
    private String maPhieuTra;

    @ManyToOne
    @JoinColumn(name = "ma_ca_biet_tb")
    private ThietBi thietBi;

    @Column(name = "tinh_trang_tra")
    private String tinhTrangTra;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "tra_tb_id") // Use the correct column name here
    private TraTB traTB;
}
