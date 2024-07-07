package com.qltb.mapper;

import com.qltb.entity.GiaoVien;
import com.qltb.model.request.create.CreateGiaoVienRequest;
import com.qltb.model.request.update.UpdateGiaoVienRequest;
import com.qltb.model.response.GiaoVienResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GiaoVienMapper {
    GiaoVien toGiaoVien(CreateGiaoVienRequest request);
    void updateGiaoVien(@MappingTarget GiaoVien giaoVien, UpdateGiaoVienRequest request);
    @Mapping(target = "toCM", ignore = true)
    GiaoVienResponse toGiaoVienResponse(GiaoVien giaoVien);
}
