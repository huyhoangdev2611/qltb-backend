package com.qltb.mapper;

import com.qltb.entity.MonHoc;
import com.qltb.model.request.create.CreateMonHocRequest;
import com.qltb.model.request.update.UpdateMonHocRequest;
import com.qltb.model.response.MonHocResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MonHocMapper {
    MonHoc toMonHoc(CreateMonHocRequest request);
    void updateMonHoc(@MappingTarget MonHoc monHoc, UpdateMonHocRequest request);
    MonHocResponse toMonHocResponse(MonHoc monHoc);
}
