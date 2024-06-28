package com.qltb.mapper;

import com.qltb.entity.GiamTB;
import com.qltb.model.request.create.CreateGiamTBRequest;
import com.qltb.model.request.update.UpdateGiamTBRequest;
import com.qltb.model.response.GiamTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GiamTBMapper {
    GiamTB toGiamTB(CreateGiamTBRequest request);
    void updateGiamTB(@MappingTarget GiamTB giamTB, UpdateGiamTBRequest request);
    GiamTBResponse toGiamTBResponse(GiamTB giamTB);
}
