package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_tra_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietTraTB {
    @EmbeddedId
    private ChiTietTraTBKey id;

    @Column(name = "sl_tra")
    private int slTra;

    @Column(name = "sl_hong")
    private int slHong;

    @Column(name = "sl_mat")
    private int slMat;

    @Column(name = "sl_tieu_hao")
    private int slTieuHao;

    @ManyToOne
    @MapsId("maPhieuTra")
    @JoinColumn(name = "ma_phieu_tra")
    private TraTB traTB;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;
}
