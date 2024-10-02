package com.qltb.repository;

import com.qltb.entity.LoaiTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTBRepository extends JpaRepository<LoaiTB, String> {
}
