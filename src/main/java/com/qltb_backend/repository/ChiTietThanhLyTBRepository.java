package com.qltb_backend.repository;

import com.qltb_backend.entity.ChiTietThanhLyTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietThanhLyTBRepository extends JpaRepository<ChiTietThanhLyTB, String> {
}
