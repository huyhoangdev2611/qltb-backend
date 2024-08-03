package com.qltb.repository;

import com.qltb.entity.TraTB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraTBRepository extends JpaRepository<TraTB, String> {
    Optional<TraTB>  findTopByOrderByMaPhieuTraDesc();
    Page<TraTB> findAll(Pageable pageable);
    Page<TraTB> findByMuonTB_MaPhieuMuonContainingIgnoreCaseOrderByMaPhieuTraAsc(Pageable pageable, String maPhieuMuon);

}
