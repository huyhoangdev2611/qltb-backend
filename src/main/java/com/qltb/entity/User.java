package com.qltb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ma_gv", unique = true, nullable = false)
    private String maGV;

    @Column(name = "flag", nullable = false)
    private Boolean flag = false;

    @OneToOne
    @JoinColumn(name = "ma_gv", referencedColumnName = "ma_gv", insertable = false, updatable = false)
    private GiaoVien giaoVien;
}
