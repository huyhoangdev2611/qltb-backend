package com.qltb.repository;

import com.qltb.entity.MuonTB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuonTBRepository extends JpaRepository<MuonTB, String> {
    Optional<MuonTB> findTopByOrderByMaPhieuMuonDesc();

    @Query("SELECT m FROM MuonTB m")
    Page<MuonTB> getAll(Pageable pageable);

    Page<MuonTB> findByGiaoVien_TenGVContainingIgnoreCaseOrderByMaPhieuMuonAsc(Pageable pageable, String tenGiaoVien);
}
