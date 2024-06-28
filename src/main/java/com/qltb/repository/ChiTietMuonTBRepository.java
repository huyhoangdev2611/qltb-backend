package com.qltb.repository;

import com.qltb.entity.ChiTietMuonTB;
import com.qltb.entity.ChiTietMuonTBKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietMuonTBRepository extends JpaRepository<ChiTietMuonTB, ChiTietMuonTBKey> {
}
