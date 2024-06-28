package com.qltb.repository;

import com.qltb.entity.KhoPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoPhongRepository extends JpaRepository<KhoPhong, String> {
}
