package com.qltb.mapper;

import com.qltb.entity.DMThietBi;
import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DMThietBiMapper {
    DMThietBi toDMThietBi(CreateDMThietBiRequest request);
    void updateDMThietBi(@MappingTarget DMThietBi dmThietBi, UpdateDMThietBiRequest request);
    @Mapping(target = "loaiTB", ignore = true)
    @Mapping(target = "donViTinh", ignore = true)
//    @Mapping(target = "maDVT", ignore = true)
    DMThietBiResponse toDMThietBiResponse(DMThietBi dmThietBi);
}
