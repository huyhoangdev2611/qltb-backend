package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "loai_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoaiTB {
    @Id
    @Column(name = "ma_loai_tb")
    private String maLoaiTB;

    @Column(name = "ten_loai_tb")
    private String tenLoaiTB;

    @OneToMany(mappedBy = "loaiTB")
    private List<DMThietBi> dmThietBis;
}
