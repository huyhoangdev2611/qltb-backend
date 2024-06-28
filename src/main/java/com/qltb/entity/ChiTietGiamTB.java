package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_giam_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietGiamTB {
    @EmbeddedId
    private ChiTietGiamTBKey id;

    @Column(name = "sl_hong")
    private int slHong;

    @Column(name = "sl_mat")
    private int slMat;

    @Column(name = "sl_con_dung_duoc")
    private int slConDungDuoc;

    @ManyToOne
    @MapsId("maPhieuGiam")
    @JoinColumn(name = "ma_phieu_giam")
    private GiamTB giamTB;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;
}
