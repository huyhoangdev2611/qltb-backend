package com.qltb.mapper;

import com.qltb.entity.NguonCap;
import com.qltb.model.request.create.CreateNguonCapRequest;
import com.qltb.model.request.update.UpdateNguonCapRequest;
import com.qltb.model.response.NguonCapResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NguonCapMapper {
    NguonCap toNguonCap(CreateNguonCapRequest request);
    void updateNguonCap(@MappingTarget NguonCap nguonCap, UpdateNguonCapRequest request);
    NguonCapResponse toNguonCapResponse(NguonCap nguonCap);
}
