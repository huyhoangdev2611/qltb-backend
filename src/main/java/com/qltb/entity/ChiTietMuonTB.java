package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_muon_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietMuonTB {
    @EmbeddedId
    private ChiTietMuonTBKey id;

    @Column(name = "sl_muon")
    private int slMuon;

    @ManyToOne
    @MapsId("maPhieuMuon")
    @JoinColumn(name = "ma_phieu_muon")
    private MuonTB muonTB;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;
}
