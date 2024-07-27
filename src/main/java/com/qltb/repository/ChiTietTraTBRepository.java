package com.qltb.repository;

import com.qltb.entity.ChiTietTraTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietTraTBRepository extends JpaRepository<ChiTietTraTB, String> {
}
