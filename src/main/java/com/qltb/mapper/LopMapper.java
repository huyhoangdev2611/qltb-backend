package com.qltb.mapper;

import com.qltb.entity.Lop;
import com.qltb.model.request.create.CreateLopRequest;
import com.qltb.model.request.update.UpdateLopRequest;
import com.qltb.model.response.LopResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LopMapper {
    Lop toLop(CreateLopRequest request);
    void updateLop(@MappingTarget Lop lop, UpdateLopRequest request);
    LopResponse toLopResponse(Lop lop);
}
