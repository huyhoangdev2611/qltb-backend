package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "mon_hoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonHoc {
    @Id
    @Column(name = "ma_mon_hoc")
    private String maMonHoc;

    @Column(name = "ten_mon_hoc")
    private String tenMonHoc;

    @OneToMany(mappedBy = "monHoc")
    private List<DMThietBi> dmThietBis;

    @OneToMany(mappedBy = "monHoc")
    private List<MuonTB> muonTBs;
}
