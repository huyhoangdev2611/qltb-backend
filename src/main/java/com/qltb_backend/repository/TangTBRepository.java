package com.qltb_backend.repository;

import com.qltb_backend.entity.TangTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TangTBRepository extends JpaRepository<TangTB, String> {
}
