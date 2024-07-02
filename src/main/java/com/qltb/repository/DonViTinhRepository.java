package com.qltb.repository;

import com.qltb.entity.DonViTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonViTinhRepository extends JpaRepository<DonViTinh, String> {
    Optional<DonViTinh> findTopByOrderByMaDVTDesc();
}
