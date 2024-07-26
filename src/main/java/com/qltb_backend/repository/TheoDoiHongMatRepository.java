package com.qltb_backend.repository;

import com.qltb_backend.entity.TheoDoiHongMat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoDoiHongMatRepository extends JpaRepository<TheoDoiHongMat, String> {
}
