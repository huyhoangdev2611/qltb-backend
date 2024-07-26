package com.qltb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "mon_hoc")
public class MonHoc {
    @Id
    @Column(name = "ma_mon_hoc", length = 10)
    private String maMonHoc;

    @Column(name = "ten_mon_hoc")
    private String tenMonHoc;

    @OneToMany(mappedBy = "monHoc")
    private List<NhomThietBi> nhomThietBiList;
}
