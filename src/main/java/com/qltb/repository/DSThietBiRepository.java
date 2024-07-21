package com.qltb.repository;

import com.qltb.entity.DSThietBi;
import com.qltb.entity.DSThietBiKey;
import com.qltb.model.response.KhoPhongResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DSThietBiRepository extends JpaRepository<DSThietBi, DSThietBiKey> {
    boolean existsByMaTBAndMaKP(String maTB, String maKP);

    @Query("SELECT SUM(d.soLuong) FROM DSThietBi d WHERE d.maTB = :maTB")
    Integer sumSoLuongByMaTB(@Param("maTB") String maTB);

    Page<DSThietBi> findByTenTBContainingIgnoreCaseOrderByMaTBAsc(Pageable pageable, String name);

    //    @Query("select distinct d from DSThietBi d group by d.maTB")
    @Query("SELECT d FROM DSThietBi d WHERE d.id IN (SELECT MIN(d2.id) FROM DSThietBi d2 GROUP BY d2.maTB) ORDER BY d.maTB ASC")
    List<DSThietBi> getDistinctByMaTB();

    @Query("SELECT DISTINCT new com.qltb.model.response.KhoPhongResponse(k.maKP, k.tenKP) " +
            "FROM KhoPhong k JOIN DSThietBi ds ON k.maKP = ds.maKP " +
            "WHERE ds.dmThietBi.maTB = :maTB")
    List<KhoPhongResponse> findKhoPhongByMaTB(@Param("maTB") String maTB);

    DSThietBi findDSThietBiByMaTBAndMaKP(String maTB, String maKP);
}
