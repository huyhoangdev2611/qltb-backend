package com.qltb.mapper;

import com.qltb.entity.ThanhLyTB;
import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.request.update.ThanhLyTBUpdateRequest;
import com.qltb.model.response.ThanhLyTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ThanhLyTBMapper {
    ThanhLyTB toThanhLyTB(ThanhLyTBCreateRequest request);

    @Mapping(target = "chiTietThanhLyTBList", ignore = true)
    ThanhLyTBResponse toThanhLyTBResponse(ThanhLyTB thanhLyTB);

    void updateThanhLyTB(@MappingTarget ThanhLyTB thanhLyTB, ThanhLyTBUpdateRequest request);
}
