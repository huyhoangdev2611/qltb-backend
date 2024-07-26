package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tra_tb")
public class TraTB {
    @Id
    @Column(name = "ma_phieu_tra", length = 10)
    private String maPhieuTra;

    @Column(name = "ngay_tra")
    private Date ngayTra;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_muon")
    private MuonTB muonTB;

    @OneToMany(mappedBy = "traTB")
    private List<ChiTietTraTB> chiTietTraTBList;
}
