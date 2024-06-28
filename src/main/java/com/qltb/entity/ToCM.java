package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "to_cm")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToCM {
    @Id
    @Column(name = "ma_to_cm")
    private String maToCM;

    @Column(name = "ten_to_cm")
    private String tenToCM;

    @OneToMany(mappedBy = "toCM")
    private List<GiaoVien> giaoViens;
}
