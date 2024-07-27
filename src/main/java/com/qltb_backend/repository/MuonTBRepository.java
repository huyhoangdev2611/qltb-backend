package com.qltb_backend.repository;

import com.qltb_backend.entity.MuonTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuonTBRepository extends JpaRepository<MuonTB, String> {
}
