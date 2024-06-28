package com.qltb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DSThietBiKey implements Serializable {
    @Column(name = "ma_tb")
    private String maTB;

    @Column(name = "ma_kp")
    private String maKP;
}
