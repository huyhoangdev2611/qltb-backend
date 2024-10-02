package com.qltb.mapper;

import com.qltb.entity.NhomThietBi;
import com.qltb.model.request.create.NhomThietBiCreateRequest;
import com.qltb.model.request.update.NhomThietBiUpdateRequest;
import com.qltb.model.response.NhomThietBiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NhomThietBiMapper {
    NhomThietBi toNhomThietBi(NhomThietBiCreateRequest request);
    void updateNhomThietBi(@MappingTarget NhomThietBi dmThietBi, NhomThietBiUpdateRequest request);
    @Mapping(target = "loaiTB", ignore = true)
    @Mapping(target = "donViTinh", ignore = true)
    @Mapping(target = "maDVT", ignore = true)
    NhomThietBiResponse toNhomThietBiResponse(NhomThietBi dmThietBi);
}