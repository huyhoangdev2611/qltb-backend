package com.qltb_backend.repository;

import com.qltb_backend.entity.LoaiTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTBRepository extends JpaRepository<LoaiTB, String> {
}
