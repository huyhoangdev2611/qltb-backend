package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "to_cm")
public class ToCM {
    @Id
    @Column(name = "ma_to_cm", length = 10)
    private String maToCM;

    @Column(name = "ten_to_cm")
    private String tenToCM;

    @OneToMany(mappedBy = "toCM")
    private List<GiaoVien> giaoVienList;
}
