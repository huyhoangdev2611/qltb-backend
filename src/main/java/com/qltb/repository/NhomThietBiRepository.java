package com.qltb.repository;

import com.qltb.entity.NhomThietBi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhomThietBiRepository extends JpaRepository<NhomThietBi, String> {
    Optional<NhomThietBi> findTopByOrderByMaNTBDesc();
    Page<NhomThietBi> findByTenNTBContainingIgnoreCaseOrderByMaNTB(Pageable pageable, String name);
    List<NhomThietBi> findByTenNTBContainingIgnoreCase(String name);

//    @Query("select dm from NhomThietBi dm where dm.maTB in (select ds.maTB from DSThietBi ds) order by dm.maTB asc")
//    List<NhomThietBi> getInDSThietBi();
}
