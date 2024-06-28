package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tra_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraTB {
    @Id
    @Column(name = "ma_phieu_tra")
    private String maPhieuTra;

    @Column(name = "ngay_tra")
    private LocalDate ngayTra;

    @Column(name = "ma_phieu_muon")
    private String maPhieuMuon;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_muon", insertable = false, updatable = false)
    private MuonTB muonTB;

    @OneToMany(mappedBy = "traTB")
    private List<ChiTietTraTB> chiTietTraTBs;
}
