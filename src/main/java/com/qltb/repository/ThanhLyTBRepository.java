package com.qltb.repository;

import com.qltb.entity.ThanhLyTB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThanhLyTBRepository extends JpaRepository<ThanhLyTB, String> {
    Optional<ThanhLyTB> findTopByOrderByMaPhieuThanhLyDesc();

    Page<ThanhLyTB> findByMaPhieuThanhLyContainingIgnoreCaseOrderByMaPhieuThanhLyAsc(String maPhieuThanhLy, Pageable pageable);
}
