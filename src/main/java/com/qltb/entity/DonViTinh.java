package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "don_vi_tinh")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonViTinh {
    @Id
    @Column(name = "ma_dvt")
    private String maDVT;

    @Column(name = "ten_dvt")
    private String tenDVT;

    @OneToMany(mappedBy = "donViTinh")
    private List<DMThietBi> dmThietBis;
}
