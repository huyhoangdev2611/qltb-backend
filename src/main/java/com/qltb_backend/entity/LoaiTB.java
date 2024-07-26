package com.qltb_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "loai_tb")
public class LoaiTB {
    @Id
    @Column(name = "ma_loai_tb", length = 10)
    private String maLoaiTB;

    @Column(name = "ten_loai_tb")
    private String tenLoaiTB;

    @OneToMany(mappedBy = "loaiTB")
    private List<NhomThietBi> nhomThietBiList;
}
