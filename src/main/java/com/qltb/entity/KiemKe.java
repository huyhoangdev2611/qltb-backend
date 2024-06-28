package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "kiem_ke")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KiemKe {
    @Id
    @Column(name = "ma_kiem_ke")
    private String maKiemKe;

    @Column(name = "ngay_lap")
    private LocalDate ngayLap;

    @Column(name = "noi_dung")
    private String noiDung;

    @OneToMany(mappedBy = "kiemKe")
    private List<ChiTietKiemKe> chiTietKiemKes;
}
