package com.qltb_backend.repository;

import com.qltb_backend.entity.NguonCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguonCapRepository extends JpaRepository<NguonCap, String> {
}
