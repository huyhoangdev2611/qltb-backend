package com.qltb.repository;

import com.qltb.entity.ChiTietKiemKe;
import com.qltb.entity.ChiTietKiemKeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietKiemKeRepository extends JpaRepository<ChiTietKiemKe, ChiTietKiemKeKey> {
}
