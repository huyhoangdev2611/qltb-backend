package com.qltb_backend.repository;

import com.qltb_backend.entity.DonViTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonViTinhRepository extends JpaRepository<DonViTinh, String> {
}
