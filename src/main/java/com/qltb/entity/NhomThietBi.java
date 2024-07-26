package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "dm_nhom_thiet_bi")
public class NhomThietBi {
    @Id
    @Column(name = "ma_ntb", length = 10)
    private String maNTB;

    @Column(name = "ten_ntb")
    private String tenNTB;

    @ManyToOne
    @JoinColumn(name = "ma_dvt")
    private DonViTinh donViTinh;

    @ManyToOne
    @JoinColumn(name = "ma_mon_hoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "ma_loai_tb")
    private LoaiTB loaiTB;

    @Column(name = "sl_toi_thieu")
    private int slToiThieu;

    @Column(name = "tb_tu_lam")
    private boolean tbTuLam;

    @Column(name = "tb_tieu_hao")
    private boolean tbTieuHao;

    @Column(name = "mo_ta")
    private String moTa;

    @OneToMany(mappedBy = "nhomThietBi")
    private List<ThietBi> thietBiList;
}
