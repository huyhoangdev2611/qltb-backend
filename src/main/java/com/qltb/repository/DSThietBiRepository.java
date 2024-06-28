package com.qltb.repository;

import com.qltb.entity.DSThietBi;
import com.qltb.entity.DSThietBiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DSThietBiRepository extends JpaRepository<DSThietBi, DSThietBiKey> {
}
