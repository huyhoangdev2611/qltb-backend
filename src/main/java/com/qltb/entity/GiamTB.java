package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "giam_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiamTB {
    @Id
    @Column(name = "ma_phieu_giam")
    private String maPhieuGiam;

    @Column(name = "ngay_lap")
    private LocalDate ngayLap;

    @Column(name = "noi_dung")
    private String noiDung;

    @OneToMany(mappedBy = "giamTB")
    private List<ChiTietGiamTB> chiTietGiamTBs;
}
