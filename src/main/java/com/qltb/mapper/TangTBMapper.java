package com.qltb.mapper;

import com.qltb.entity.TangTB;
import com.qltb.model.request.create.TangTBCreateRequest;
import com.qltb.model.request.update.TangTBUpdateRequest;
import com.qltb.model.response.TangTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TangTBMapper {
    @Mapping(target = "chiTietTangTBList", ignore = true)
    TangTB toTangTB(TangTBCreateRequest request);

    @Mapping(target = "nguonCap", source = "tangTB.nguonCap.tenNguonCap")
    @Mapping(target = "chiTietTangTBList", ignore = true)
    TangTBResponse toTangTBResponse(TangTB tangTB);

//    @Mapping(target = "chiTietTangTBList", ignore = true)
//    TangTB toTangTB(@MappingTarget TangTB tangTB, TangTBUpdateRequest request);
}
