package com.qltb_backend.repository;

import com.qltb_backend.entity.ThanhLyTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanhLyTBRepository extends JpaRepository<ThanhLyTB, String> {
}
