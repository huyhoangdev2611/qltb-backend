package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chi_tiet_kiem_ke")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietKiemKe {
    @EmbeddedId
    private ChiTietKiemKeKey id;

    @Column(name = "sl_hong")
    private int slHong;

    @Column(name = "sl_mat")
    private int slMat;

    @Column(name = "sl_con_dung_duoc")
    private int slConDungDuoc;

    @ManyToOne
    @MapsId("maKiemKe")
    @JoinColumn(name = "ma_kiem_ke")
    private KiemKe kiemKe;

    @ManyToOne
    @MapsId("maTB")
    @JoinColumn(name = "ma_tb")
    private DMThietBi dmThietBi;

    @ManyToOne
    @MapsId("maKP")
    @JoinColumn(name = "ma_kp")
    private KhoPhong khoPhong;
}
