package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "giao_vien")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiaoVien {
    @Id
    @Column(name = "ma_gv")
    private String maGV;

    @Column(name = "ten_gv")
    private String tenGV;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ma_to_cm")
    private String maToCM;

    @ManyToOne
    @JoinColumn(name = "ma_to_cm", insertable = false, updatable = false)
    private ToCM toCM;

    @OneToMany(mappedBy = "giaoVien")
    private List<TheoDoiHongMat> theoDoiHongMats;

    @OneToMany(mappedBy = "giaoVien")
    private List<MuonTB> muonTBs;
}