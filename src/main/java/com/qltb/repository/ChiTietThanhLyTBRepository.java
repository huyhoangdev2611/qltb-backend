package com.qltb.repository;

import com.qltb.entity.ChiTietThanhLyTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietThanhLyTBRepository extends JpaRepository<ChiTietThanhLyTB, String> {
    void deleteByMaCaBietTB(String maCaBietTB);
}
