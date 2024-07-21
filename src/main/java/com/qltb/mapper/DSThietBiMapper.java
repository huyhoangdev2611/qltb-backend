package com.qltb.mapper;

import com.qltb.entity.DSThietBi;
import com.qltb.model.request.create.CreateDSThietBiRequest;
import com.qltb.model.request.update.UpdateDSThietBiRequest;
import com.qltb.model.response.DSThietBiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DSThietBiMapper {
    @Mapping(target = "trongKho", source = "soLuong")
    DSThietBi toDSThietBi(CreateDSThietBiRequest request);
    void updateDSThietBi(@MappingTarget DSThietBi dsThietBi, UpdateDSThietBiRequest request);
    DSThietBiResponse toDSThietBiResponse(DSThietBi dsThietBi);
}
