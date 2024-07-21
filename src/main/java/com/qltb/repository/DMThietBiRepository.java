package com.qltb.repository;

import com.qltb.entity.DMThietBi;
import com.qltb.model.response.KhoPhongResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DMThietBiRepository extends JpaRepository<DMThietBi, String> {
    Optional<DMThietBi> findTopByOrderByMaTBDesc();
    Page<DMThietBi> findByTenTBContainingIgnoreCaseOrderByMaTB(Pageable pageable, String name);
    List<DMThietBi> findByTenTBContainingIgnoreCase(String name);

    @Query("select dm from DMThietBi dm where dm.maTB in (select ds.maTB from DSThietBi ds) order by dm.maTB asc")
    List<DMThietBi> getInDSThietBi();
}
