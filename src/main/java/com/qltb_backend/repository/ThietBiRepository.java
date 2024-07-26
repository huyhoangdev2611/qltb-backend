package com.qltb_backend.repository;

import com.qltb_backend.entity.ThietBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi, String> {
}
