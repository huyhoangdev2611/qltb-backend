package com.qltb.repository;

import com.qltb.entity.NhomThietBi;
import com.qltb.entity.ThietBi;
import com.qltb.model.response.ThietBiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi, String> {
    Optional<ThietBi> findTopByMaNTBOrderByMaCaBietTBDesc(String maNTB);
    List<ThietBi> findByMaNTB(String maNTB);

    @Query("select count(tb) from ThietBi tb where tb.maNTB = :maNTB")
    int countTB(String maNTB);

//    Page<ThietBi> findByTenNTBContainingIgnoreCaseOrderByMaCaBietTB();
}
