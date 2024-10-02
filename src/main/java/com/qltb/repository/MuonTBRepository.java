package com.qltb.repository;

import com.qltb.entity.MuonTB;
import com.qltb.model.response.MonthlyBorrowedDevicesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MuonTBRepository extends JpaRepository<MuonTB, String> {
    Optional<MuonTB> findTopByOrderByMaPhieuMuonDesc();

    @Query("SELECT m FROM MuonTB m")
    Page<MuonTB> getAll(Pageable pageable);


    @Query("SELECT new com.qltb.model.response.MonthlyBorrowedDevicesResponse(MONTH(m.ngayMuon), COUNT(m)) " +
            "FROM MuonTB m GROUP BY MONTH(m.ngayMuon)")
    List<MonthlyBorrowedDevicesResponse> countMonthlyBorrowedDevices();

    Page<MuonTB> findByGiaoVien_TenGVContainingIgnoreCase(Pageable pageable, String name);

}
