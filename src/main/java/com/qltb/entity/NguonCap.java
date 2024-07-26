package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "nguon_cap")
public class NguonCap {
    @Id
    @Column(name = "ma_nguon_cap", length = 10)
    private String maNguonCap;

    @Column(name = "ten_nguon_cap")
    private String tenNguonCap;

    @OneToMany(mappedBy = "nguonCap")
    private List<TangTB> tangTBList;
}
