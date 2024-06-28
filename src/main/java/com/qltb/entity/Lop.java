package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lop {
    @Id
    @Column(name = "ma_lop")
    private String maLop;

    @Column(name = "ten_lop")
    private String tenLop;

    @OneToMany(mappedBy = "lop")
    private List<MuonTB> muonTBs;
}
