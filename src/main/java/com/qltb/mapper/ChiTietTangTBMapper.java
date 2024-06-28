package com.qltb.mapper;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.model.request.create.CreateChiTietTangTBRequest;
import com.qltb.model.request.update.UpdateChiTietTangTBRequest;
import com.qltb.model.response.ChiTietTangTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChiTietTangTBMapper {
    ChiTietTangTB toChiTietTangTB(CreateChiTietTangTBRequest request);
    void updateChiTietTangTB(@MappingTarget ChiTietTangTB chiTietTangTB, UpdateChiTietTangTBRequest request);
    ChiTietTangTBResponse toChiTietTangTBResponse(ChiTietTangTB chiTietTangTB);
}
