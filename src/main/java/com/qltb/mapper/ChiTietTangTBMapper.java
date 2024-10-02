package com.qltb.mapper;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.model.request.create.ChiTietMuonTBCreateRequest;
import com.qltb.model.request.create.ChiTietTangTBCreateRequest;
import com.qltb.model.response.ChiTietTangTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChiTietTangTBMapper {
    ChiTietTangTB toChiTietTangTB(ChiTietTangTBCreateRequest request);

    @Mapping(target = "tenNTB", source = "chiTietTangTB.nhomThietBi.tenNTB")
    @Mapping(target = "thanhTienString", expression = "java(String.format(\"%,d\", chiTietTangTB.getSoLuong() * chiTietTangTB.getDonGia()))")
    ChiTietTangTBResponse toChiTietTangTBResponse(ChiTietTangTB chiTietTangTB);
}
