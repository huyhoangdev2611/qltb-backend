package com.qltb.repository;

import com.qltb.entity.GiaoVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVien, String> {
    Optional<GiaoVien> findTopByOrderByMaGVDesc();
    Page<GiaoVien>  findByTenGVContainingIgnoreCaseOrderByMaGVAsc(Pageable pageable, String name);
}