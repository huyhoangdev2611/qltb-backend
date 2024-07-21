package com.qltb.mapper;

import com.qltb.entity.TangTB;
import com.qltb.model.request.create.CreateTangTBRequest;
import com.qltb.model.request.update.UpdateTangTBRequest;
import com.qltb.model.response.TangTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TangTBMapper {
    @Mapping(target = "maPhieuTang", ignore = true)
    TangTB toTangTB(CreateTangTBRequest request);
    void updateTangTB(@MappingTarget TangTB tangTB, UpdateTangTBRequest request);
    TangTBResponse toTangTBResponse(TangTB tangTB);
}
