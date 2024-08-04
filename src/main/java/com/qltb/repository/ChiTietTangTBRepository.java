package com.qltb.repository;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.model.response.ChiTietTangTBResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietTangTBRepository extends JpaRepository<ChiTietTangTB, String> {
    public List<ChiTietTangTB> findAllByMaPhieuTang(String maPhieuTang);
}
