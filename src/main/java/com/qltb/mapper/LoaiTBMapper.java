package com.qltb.mapper;

import com.qltb.entity.LoaiTB;
import com.qltb.model.request.create.CreateLoaiTBRequest;
import com.qltb.model.request.update.UpdateLoaiTBRequest;
import com.qltb.model.response.LoaiTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoaiTBMapper {
    LoaiTB toLoaiTB(CreateLoaiTBRequest request);
    void updateLoaiTB(@MappingTarget LoaiTB loaiTB, UpdateLoaiTBRequest request);
    LoaiTBResponse toLoaiTBResponse(LoaiTB loaiTB);
}
