package com.qltb.repository;

import com.qltb.entity.GiamTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamTBRepository extends JpaRepository<GiamTB, String> {
}
