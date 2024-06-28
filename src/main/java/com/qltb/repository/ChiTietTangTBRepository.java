package com.qltb.repository;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.ChiTietTangTBKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietTangTBRepository extends JpaRepository<ChiTietTangTB, ChiTietTangTBKey> {
}
