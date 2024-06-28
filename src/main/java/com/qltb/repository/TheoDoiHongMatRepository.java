package com.qltb.repository;

import com.qltb.entity.TheoDoiHongMat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoDoiHongMatRepository extends JpaRepository<TheoDoiHongMat, String> {
}
