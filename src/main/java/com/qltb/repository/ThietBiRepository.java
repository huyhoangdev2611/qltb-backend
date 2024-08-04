package com.qltb.repository;

import com.qltb.entity.NhomThietBi;
import com.qltb.entity.ThietBi;
import com.qltb.model.response.ThietBiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi, String> {
    Optional<ThietBi> findTopByMaNTBOrderByMaCaBietTBDesc(String maNTB);
    List<ThietBi> findByMaNTB(String maNTB);

    @Query("select count(tb) from ThietBi tb where tb.maNTB = :maNTB")
    int countTB(String maNTB);

    // cho ghi giảm
    @Query("select tb from ThietBi tb where tb.trangThai not in ('Đã thanh lý', 'Đã mất') order by tb.maCaBietTB")
    List<ThietBi> findAllChuaThanhLy(Sort maCaBietTB);

    Page<ThietBi> findByMaCaBietTBContainingIgnoreCaseOrderByMaCaBietTB(String maCaBietTB, Pageable pageable);

    List<ThietBi> findByMaCaBietTBContainingIgnoreCaseOrderByMaCaBietTB(String maCaBietTB);

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' order by tb.maCaBietTB")
    List<ThietBi> getAllCoTheGhiGiam();

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and LOWER(tb.maCaBietTB) like LOWER(CONCAT('%', :maCaBietTB, '%')) order by tb.maCaBietTB")
    List<ThietBi> getAllCoTheGhiGiam(String maCaBietTB);

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and tb.tinhTrang = 'Dùng được' and tb.dangHoatDong = true")
    List<ThietBi> getAllCoTheMuon();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.trangThai = 'Trong kho'")
    long countByTrangThaiTrongKho();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.tinhTrang = 'Hỏng'")
    long countByTinhTrangHong();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.trangThai = 'Đã mất'")
    long countByTrangThaiDaMat();
}
