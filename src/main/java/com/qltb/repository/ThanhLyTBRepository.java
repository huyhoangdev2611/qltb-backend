package com.qltb.repository;

import com.qltb.entity.ThanhLyTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanhLyTBRepository extends JpaRepository<ThanhLyTB, String> {
}
