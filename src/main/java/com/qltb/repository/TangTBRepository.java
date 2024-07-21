package com.qltb.repository;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.TangTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TangTBRepository extends JpaRepository<TangTB, String> {
    Optional<TangTB> findTopByOrderByMaPhieuTangDesc();

}
