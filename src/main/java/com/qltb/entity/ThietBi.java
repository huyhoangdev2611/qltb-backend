package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "thiet_bi")
public class ThietBi {
    @Id
    @Column(name = "ma_ca_biet_tb", length = 10)
    private String maCaBietTB;

    @Column(name = "ma_ntb")
    private String maNTB;

    @ManyToOne
    @JoinColumn(name = "ma_ntb", insertable = false, updatable = false)
    private NhomThietBi nhomThietBi;

    @Column(name = "ma_kp")
    private String maKP;

    @ManyToOne
    @JoinColumn(name = "ma_kp", insertable = false, updatable = false)
    private KhoPhong khoPhong;

    @Column(name = "ngay_nhap")
    private LocalDate ngayNhap;

    @Column(name = "han_su_dung")
    private LocalDate hanSuDung;

    @Column(name = "trang_thai")
    private String trangThai = "Trong kho";

    @Column(name = "tinh_trang")
    private String tinhTrang = "Dùng được";

    @Column(name = "dang_hoat_dong")
    private boolean dangHoatDong = true;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietMuonTB> chiTietMuonTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietTraTB> chiTietTraTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietThanhLyTB> chiTietThanhLyTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<TheoDoiHongMat> theoDoiHongMatList;
}
