package com.qltb.repository;

import com.qltb.entity.ChiTietMuonTB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietMuonTBRepository extends JpaRepository<ChiTietMuonTB, String> {
    void deleteByMaPhieuMuon(String maPhieuMuon);

    List<ChiTietMuonTB> findByMaPhieuMuon(String maPhieuMuon);
}
