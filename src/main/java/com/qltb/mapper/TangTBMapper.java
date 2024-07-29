package com.qltb.mapper;

import com.qltb.entity.TangTB;
import com.qltb.model.request.create.TangTBCreateRequest;
import com.qltb.model.response.TangTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TangTBMapper {
    TangTB toTangTB(TangTBCreateRequest request);

    @Mapping(target = "nguonCap", source = "tangTB.nguonCap.tenNguonCap")
    TangTBResponse toTangTBResponse(TangTB tangTB);
}
