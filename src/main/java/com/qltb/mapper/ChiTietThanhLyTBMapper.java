package com.qltb.mapper;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.ChiTietThanhLyTB;
import com.qltb.model.request.create.ChiTietTangTBCreateRequest;
import com.qltb.model.request.create.ChiTietThanhLyTBCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChiTietThanhLyTBMapper {
    @Mapping(target = "maPhieuThanhLy", source = "maPhieuThanhLy")
    ChiTietThanhLyTB toChiTietThanhLyTB(ChiTietThanhLyTBCreateRequest request, String maPhieuThanhLy);
}
