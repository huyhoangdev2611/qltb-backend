package com.qltb_backend.repository;

import com.qltb_backend.entity.TraTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraTBRepository extends JpaRepository<TraTB, String> {
}
