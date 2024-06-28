package com.qltb.repository;

import com.qltb.entity.ToCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToCMRepository extends JpaRepository<ToCM, String> {
}
