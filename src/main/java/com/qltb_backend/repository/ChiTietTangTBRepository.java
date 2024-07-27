package com.qltb_backend.repository;

import com.qltb_backend.entity.ChiTietTangTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietTangTBRepository extends JpaRepository<ChiTietTangTB, String> {
}
