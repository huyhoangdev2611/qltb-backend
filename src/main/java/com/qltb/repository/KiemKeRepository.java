package com.qltb.repository;

import com.qltb.entity.KiemKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KiemKeRepository extends JpaRepository<KiemKe, String> {
}
