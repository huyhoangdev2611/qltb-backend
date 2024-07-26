package com.qltb_backend.repository;

import com.qltb_backend.entity.ToCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToCMRepository extends JpaRepository<ToCM, String> {
}
