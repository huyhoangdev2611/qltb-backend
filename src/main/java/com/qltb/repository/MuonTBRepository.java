package com.qltb.repository;

import com.qltb.entity.MuonTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuonTBRepository extends JpaRepository<MuonTB, String> {
}
