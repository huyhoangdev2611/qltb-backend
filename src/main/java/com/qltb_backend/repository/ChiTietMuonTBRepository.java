package com.qltb_backend.repository;

import com.qltb_backend.entity.ChiTietMuonTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietMuonTBRepository extends JpaRepository<ChiTietMuonTB, String> {
}
