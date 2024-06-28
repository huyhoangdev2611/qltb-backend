package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "nguon_cap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NguonCap {
    @Id
    @Column(name = "ma_nguon_cap")
    private String maNguonCap;

    @Column(name = "ten_nguon_cap")
    private String tenNguonCap;

    @OneToMany(mappedBy = "nguonCap")
    private List<TangTB> tangTBs;
}
