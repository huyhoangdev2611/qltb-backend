package com.qltb.mapper;

import com.qltb.entity.GiaoVien;
import com.qltb.model.request.create.GiaoVienCreateRequest;
import com.qltb.model.request.update.GiaoVienUpdateRequest;
import com.qltb.model.response.GiaoVienResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GiaoVienMapper {
    GiaoVien toGiaoVien(GiaoVienCreateRequest request);
    void updateGiaoVien(@MappingTarget GiaoVien giaoVien, GiaoVienUpdateRequest request);
    @Mapping(target = "toCM", ignore = true)
    GiaoVienResponse toGiaoVienResponse(GiaoVien giaoVien);
}