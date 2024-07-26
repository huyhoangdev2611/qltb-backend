package com.qltb_backend.repository;

import com.qltb_backend.entity.ChiTietTraTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietTraTBRepository extends JpaRepository<ChiTietTraTB, String> {
}
