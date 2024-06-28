package com.qltb.mapper;

import com.qltb.entity.KhoPhong;
import com.qltb.model.request.create.CreateKhoPhongRequest;
import com.qltb.model.request.update.UpdateKhoPhongRequest;
import com.qltb.model.response.KhoPhongResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KhoPhongMapper {
    KhoPhong toKhoPhong(CreateKhoPhongRequest request);
    void updateKhoPhong(@MappingTarget KhoPhong khoPhong, UpdateKhoPhongRequest request);
    KhoPhongResponse toKhoPhongResponse(KhoPhong khoPhong);
}
