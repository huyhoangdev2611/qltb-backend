package com.qltb.repository;

import com.qltb.entity.DMThietBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMThietBiRepository extends JpaRepository<DMThietBi, String> {
}
