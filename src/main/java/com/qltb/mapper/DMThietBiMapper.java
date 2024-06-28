package com.qltb.mapper;

import com.qltb.entity.DMThietBi;
import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DMThietBiMapper {
    DMThietBi toDMThietBi(CreateDMThietBiRequest request);
    void updateDMThietBi(@MappingTarget DMThietBi dmThietBi, UpdateDMThietBiRequest request);
    DMThietBiResponse toDMThietBiResponse(DMThietBi dmThietBi);
}
