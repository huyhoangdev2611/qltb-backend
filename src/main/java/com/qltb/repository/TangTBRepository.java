package com.qltb.repository;

import com.qltb.entity.TangTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TangTBRepository extends JpaRepository<TangTB, String> {
}
