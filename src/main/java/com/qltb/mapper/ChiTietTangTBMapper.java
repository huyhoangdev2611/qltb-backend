package com.qltb.mapper;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.model.request.create.ChiTietMuonTBCreateRequest;
import com.qltb.model.request.create.ChiTietTangTBCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChiTietTangTBMapper {
    ChiTietTangTB toChiTietTangTB(ChiTietTangTBCreateRequest request);
}
