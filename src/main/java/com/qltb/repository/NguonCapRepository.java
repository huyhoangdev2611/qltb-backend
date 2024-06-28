package com.qltb.repository;

import com.qltb.entity.NguonCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguonCapRepository extends JpaRepository<NguonCap, String> {
}
