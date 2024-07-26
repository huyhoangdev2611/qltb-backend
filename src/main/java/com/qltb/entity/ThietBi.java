package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "thiet_bi")
public class ThietBi {
    @Id
    @Column(name = "ma_ca_biet_tb", length = 10)
    private String maCaBietTB;

    @ManyToOne
    @JoinColumn(name = "ma_ntb")
    private NhomThietBi nhomThietBi;

    @ManyToOne
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;

    @Column(name = "ngay_nhap")
    private Date ngayNhap;

    @Column(name = "han_su_dung")
    private Date hanSuDung;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "tinh_trang")
    private String tinhTrang;

    @Column(name = "dang_hoat_dong")
    private boolean dangHoatDong;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietMuonTB> chiTietMuonTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietTraTB> chiTietTraTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<ChiTietThanhLyTB> chiTietThanhLyTBList;

    @OneToMany(mappedBy = "thietBi")
    private List<TheoDoiHongMat> theoDoiHongMatList;
}
