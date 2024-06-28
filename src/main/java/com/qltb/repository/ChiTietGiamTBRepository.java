package com.qltb.repository;

import com.qltb.entity.ChiTietGiamTB;
import com.qltb.entity.ChiTietGiamTBKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietGiamTBRepository extends JpaRepository<ChiTietGiamTB, ChiTietGiamTBKey> {
}
