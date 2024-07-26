package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "giao_vien")
public class GiaoVien {
    @Id
    @Column(name = "ma_gv", length = 10)
    private String maGV;

    @Column(name = "ten_gv")
    private String tenGV;

    @Column(name = "gioi_tinh", length = 3)
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "so_dien_thoai", length = 12)
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "ma_to_cm")
    private ToCM toCM;

    @OneToMany(mappedBy = "giaoVien")
    private List<MuonTB> muonTBList;

    @OneToMany(mappedBy = "giaoVien")
    private List<TheoDoiHongMat> theoDoiHongMatList;
}
