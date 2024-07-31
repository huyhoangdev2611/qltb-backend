package com.qltb.mapper;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.ChiTietThanhLyTB;
import com.qltb.model.request.create.ChiTietTangTBCreateRequest;
import com.qltb.model.request.create.ChiTietThanhLyTBCreateRequest;
import com.qltb.model.response.ChiTietThanhLyTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChiTietThanhLyTBMapper {
    @Mapping(target = "maPhieuThanhLy", source = "maPhieuThanhLy")
    ChiTietThanhLyTB toChiTietThanhLyTB(ChiTietThanhLyTBCreateRequest request, String maPhieuThanhLy);

    @Mapping(target = "tenNTB", source = "thietBi.nhomThietBi.tenNTB")
    @Mapping(target = "khoPhong", source = "thietBi.khoPhong.tenKP")
    @Mapping(target = "trangThai", source = "thietBi.trangThai")
    @Mapping(target = "tinhTrang", source = "thietBi.tinhTrang")
    @Mapping(target = "lyDoThanhLy", source = "lyDoTL")
    ChiTietThanhLyTBResponse toChiTietThanhLyTBResponse(ChiTietThanhLyTB chiTietThanhLyTB);
}
