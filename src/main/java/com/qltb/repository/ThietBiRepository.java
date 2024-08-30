package com.qltb.repository;

import com.qltb.entity.NhomThietBi;
import com.qltb.entity.ThietBi;
import com.qltb.model.response.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Query("SELECT t FROM ThietBi t WHERE " +
            "LOWER(t.maCaBietTB) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(t.nhomThietBi.tenNTB) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "ORDER BY t.maCaBietTB")
    Page<ThietBi> searchByMaCaBietTBOrTenNTB(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT t FROM ThietBi t WHERE " +
            "LOWER(t.maCaBietTB) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(t.nhomThietBi.tenNTB) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "ORDER BY t.maCaBietTB")
    List<ThietBi> searchByMaCaBietTBOrTenNTB(@Param("searchTerm") String searchTerm);

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and tb.tinhTrang != 'Đã tiêu hao' order by tb.maCaBietTB")
    List<ThietBi> getAllCoTheGhiGiam();

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and tb.tinhTrang != 'Đã tiêu hao' and LOWER(tb.maCaBietTB) like LOWER(CONCAT('%', :maCaBietTB, '%')) order by tb.maCaBietTB")
    List<ThietBi> getAllCoTheGhiGiam(String maCaBietTB);

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and tb.tinhTrang = 'Dùng được' and tb.dangHoatDong = true")
    List<ThietBi> getAllCoTheMuon();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.trangThai = 'Trong kho'")
    long countByTrangThaiTrongKho();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.tinhTrang = 'Hỏng'")
    long countByTinhTrangHong();

    @Query("SELECT COUNT(tb) FROM ThietBi tb WHERE tb.trangThai = 'Đã mất'")
    long countByTrangThaiDaMat();

    @Query("select tb from ThietBi tb where tb.trangThai = 'Trong kho' and tb.tinhTrang != 'Hỏng' order by tb.maCaBietTB")
    List<ThietBi> getAllCoTheKBHM();

    int countByMaNTB(String maNTB);

    @Query("""
            select new com.qltb.model.response.TKSoLuongTheoNTBResponse(
            tb.maNTB, 
            tb.nhomThietBi.tenNTB, 
            count(tb),
            (select count(tb2) from ThietBi tb2 where tb2.maNTB = tb.maNTB and tb2.tinhTrang = 'Hỏng'),
            (select count(tb2) from ThietBi tb2 where tb2.maNTB = tb.maNTB and tb2.tinhTrang != 'Hỏng')
            ) 
            from ThietBi tb 
            group by tb.maNTB, tb.nhomThietBi.tenNTB 
            order by tb.maNTB asc""")
    List<TKSoLuongTheoNTBResponse> tkSoLuongTheoNTB();

    @Query("""
            select new com.qltb.model.response.TKTBTangResponse(
            ctt.nhomThietBi.tenNTB,
            ctt.nhomThietBi.donViTinh.tenDVT,
            sum(ctt.soLuong),
            (select sum(ctt2.soLuong * ctt2.donGia) 
            from ChiTietTangTB ctt2 join TangTB ttb2 
            on ctt2.maPhieuTang = ttb2.maPhieuTang and ttb2.ngayLap >= :tuNgay and ttb2.ngayLap <= :denNgay
            where ctt2.nhomThietBi.tenNTB = ctt.nhomThietBi.tenNTB)
            ) 
            from ChiTietTangTB ctt
            join TangTB ttb on ctt.maPhieuTang = ttb.maPhieuTang
            where ttb.ngayLap >= :tuNgay and ttb.ngayLap <= :denNgay
            group by ctt.nhomThietBi.tenNTB, ctt.nhomThietBi.donViTinh.tenDVT
            order by sum(ctt.soLuong) asc
            """)
    List<TKTBTangResponse> tkTBTang(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
            select new com.qltb.model.response.TKThanhLyResponse(
            tl.maCaBietTB, 
            tl.thietBi.nhomThietBi.tenNTB, 
            tltb.ngayLap,
            tl.lyDoTL) 
            from ChiTietThanhLyTB tl
            join ThanhLyTB tltb
            on tl.maPhieuThanhLy = tltb.maPhieuThanhLy and tltb.ngayLap >= :tuNgay and tltb.ngayLap <= :denNgay
            """)
    List<TKThanhLyResponse> tkThanhLyTB(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
            select new com.qltb.model.response.TKTinhHinhMuonTBCuaGVResponse(
                mtb.giaoVien.tenGV
            ) 
            from MuonTB mtb
            where mtb.ngayMuon >= :tuNgay and mtb.ngayMuon <= :denNgay
            group by mtb.giaoVien.tenGV
            order by mtb.giaoVien.tenGV asc
            """
    )
    List<TKTinhHinhMuonTBCuaGVResponse> tkTinhHinhMuonTBCuaGV(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
            select new com.qltb.model.response.ThongTinMuonTBCuaGiaoVienResponse(
            ctm.thietBi.nhomThietBi.maNTB,
            ctm.thietBi.nhomThietBi.tenNTB,
            count(ctm)
            )
            from ChiTietMuonTB ctm
            join MuonTB mtb2
            on ctm.maPhieuMuon = mtb2.maPhieuMuon and mtb2.ngayMuon >= :tuNgay and mtb2.ngayMuon <= :denNgay
            where mtb2.giaoVien.tenGV = :tenGV
            group by ctm.thietBi.nhomThietBi.maNTB, ctm.thietBi.nhomThietBi.tenNTB
            """)
    List<ThongTinMuonTBCuaGiaoVienResponse> thongTinMuonTBCuaGiaoVien(String tenGV, LocalDate tuNgay, LocalDate denNgay);

    @Query("""
            select new com.qltb.model.response.TKThietBiDangMuonResponse(
            ctm.thietBi.maCaBietTB,
            ctm.thietBi.nhomThietBi.tenNTB,
            mtb.giaoVien.tenGV,
            mtb.ngayMuon,
            mtb.ngayHenTra
            )
            from ChiTietMuonTB ctm
            join MuonTB mtb
            on ctm.maPhieuMuon = mtb.maPhieuMuon and mtb.ngayMuon >= :tuNgay and mtb.ngayMuon <= :denNgay
            order by mtb.giaoVien.tenGV asc, mtb.ngayMuon asc
            """)
    List<TKThietBiDangMuonResponse> tkThietBiDangMuon(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
            select new com.qltb.model.response.TKThietBiDangMuonResponse(
            ctm.thietBi.maCaBietTB,
            ctm.thietBi.nhomThietBi.tenNTB,
            mtb.giaoVien.tenGV,
            mtb.ngayMuon,
            mtb.ngayHenTra
            )
            from ChiTietMuonTB ctm
            join MuonTB mtb
            on ctm.maPhieuMuon = mtb.maPhieuMuon and (mtb.trangThai = "Quá hạn" or CURRENT_DATE > mtb.ngayHenTra)
            order by mtb.giaoVien.tenGV, mtb.ngayHenTra desc
            """)
    List<TKThietBiDangMuonResponse> tkTBMuonQuaHan(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
        SELECT new com.qltb.model.response.TKSoLuongHongMatTieuHaoResponse(
            tb.nhomThietBi.tenNTB,
            SUM(CASE WHEN tb.tinhTrang = 'Mất' THEN 1 ELSE 0 END),
            SUM(CASE WHEN tb.tinhTrang = 'Hỏng' THEN 1 ELSE 0 END),
            SUM(CASE WHEN tb.tinhTrang = 'Đã tiêu hao' THEN 1 ELSE 0 END)
        )
        FROM ThietBi tb
        GROUP BY tb.nhomThietBi.tenNTB
    """)
    List<TKSoLuongHongMatTieuHaoResponse> tkSoLuongHongMatTieuHao(LocalDate tuNgay, LocalDate denNgay);

    @Query("""
                    select new com.qltb.model.response.ThietBiResponse(
                        tb.maCaBietTB,
                        tb.maNTB,
                        tb.nhomThietBi.tenNTB,
                        tb.khoPhong.tenKP,
                        tb.trangThai,
                        tb.tinhTrang,
                        tb.dangHoatDong
                    ) 
                    from ThietBi tb
                    where (
                    (tb.trangThai = 'Đã mất' and :isMat = true) 
                    or (tb.tinhTrang = 'Hỏng' and :isHong = true) 
                    or (tb.tinhTrang = 'Dùng được' and :isDungDuoc = true) 
                    or (tb.dangHoatDong = true and :isDangHoatDong = true))
            """)
    List<ThietBiResponse> baoCaoKiemKeTB(boolean isHong, boolean isMat, boolean isDungDuoc, boolean isDangHoatDong);
}
