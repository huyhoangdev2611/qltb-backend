package com.qltb.mapper;

import com.qltb.entity.TraTB;
import com.qltb.model.request.create.CreateTraTBRequest;
import com.qltb.model.request.update.UpdateTraTBRequest;
import com.qltb.model.response.TraTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TraTBMapper {
    TraTB toTraTB(CreateTraTBRequest request);
    void updateTraTB(@MappingTarget TraTB traTB, UpdateTraTBRequest request);
    TraTBResponse toTraTBResponse(TraTB traTB);
}
