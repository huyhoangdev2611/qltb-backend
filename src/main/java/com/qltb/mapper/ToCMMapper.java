package com.qltb.mapper;

import com.qltb.entity.ToCM;
import com.qltb.model.request.create.CreateToCMRequest;
import com.qltb.model.request.update.UpdateToCMRequest;
import com.qltb.model.response.ToCMResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ToCMMapper {
    ToCM toToCM(CreateToCMRequest request);
    void updateToCM(@MappingTarget ToCM toCM, UpdateToCMRequest request);
    ToCMResponse toToCMResponse(ToCM toCM);
}
