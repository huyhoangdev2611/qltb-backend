package com.qltb.repository;

import com.qltb.entity.GiamTB;
import com.qltb.entity.GiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiamTBRepository extends JpaRepository<GiamTB, String> {
    Optional<GiamTB> findTopByOrderByMaPhieuGiamDesc();

}
