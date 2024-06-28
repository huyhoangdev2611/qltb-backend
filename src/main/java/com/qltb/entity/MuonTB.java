package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "muon_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MuonTB {
    @Id
    @Column(name = "ma_phieu_muon")
    private String maPhieuMuon;

    @Column(name = "ngay_muon")
    private LocalDate ngayMuon;

    @Column(name = "ngay_hen_tra")
    private LocalDate ngayHenTra;

    @Column(name = "ma_gv")
    private String maGV;

    @Column(name = "ma_mon_hoc")
    private String maMonHoc;

    @Column(name = "ma_lop")
    private String maLop;

    @Column(name = "muc_dich")
    private String mucDich;

    @ManyToOne
    @JoinColumn(name = "ma_gv", insertable = false, updatable = false)
    private GiaoVien giaoVien;

    @ManyToOne
    @JoinColumn(name = "ma_mon_hoc", insertable = false, updatable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "ma_lop", insertable = false, updatable = false)
    private Lop lop;

    @OneToMany(mappedBy = "muonTB")
    private List<ChiTietMuonTB> chiTietMuonTBs;
}
