package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "dm_thiet_bi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DMThietBi {
    @Id
    @Column(name = "ma_tb")
    private String maTB;

    @Column(name = "ten_tb")
    private String tenTB;

    @Column(name = "ma_dvt")
    private String maDVT;

    @Column(name = "ma_mon_hoc")
    private String maMonHoc;

    @Column(name = "ma_loai_tb")
    private String maLoaiTB;

    @Column(name = "sl_toi_thieu")
    private int slToiThieu;

    @Column(name = "tb_tu_lam")
    private boolean tbTuLam;

    @Column(name = "tb_tieu_hao")
    private boolean tbTieuHao;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "ma_dvt", insertable = false, updatable = false)
    private DonViTinh donViTinh;

    @ManyToOne
    @JoinColumn(name = "ma_mon_hoc", insertable = false, updatable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "ma_loai_tb", insertable = false, updatable = false)
    private LoaiTB loaiTB;

    @OneToMany(mappedBy = "dmThietBi")
    private List<DSThietBi> dsThietBis;

    @OneToMany(mappedBy = "dmThietBi")
    private List<ChiTietTangTB> chiTietTangTBs;

    @OneToMany(mappedBy = "dmThietBi")
    private List<ChiTietGiamTB> chiTietGiamTBs;

    @OneToMany(mappedBy = "dmThietBi")
    private List<TheoDoiHongMat> theoDoiHongMats;

    @OneToMany(mappedBy = "dmThietBi")
    private List<ChiTietKiemKe> chiTietKiemKes;

    @OneToMany(mappedBy = "dmThietBi")
    private List<ChiTietMuonTB> chiTietMuonTBs;

    @OneToMany(mappedBy = "dmThietBi")
    private List<ChiTietTraTB> chiTietTraTBs;
}
