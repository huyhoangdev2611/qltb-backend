package com.qltb.repository;

import com.qltb.entity.DMThietBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DMThietBiRepository extends JpaRepository<DMThietBi, String> {
    Optional<DMThietBi> findTopByOrderByMaTBDesc();
}
