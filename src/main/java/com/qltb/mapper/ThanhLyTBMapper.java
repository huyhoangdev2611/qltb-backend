package com.qltb.mapper;

import com.qltb.entity.ThanhLyTB;
import com.qltb.model.request.create.ThanhLyTBCreateRequest;
import com.qltb.model.response.ThanhLyTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThanhLyTBMapper {
    ThanhLyTB toThanhLyTB(ThanhLyTBCreateRequest request);
    ThanhLyTBResponse toThanhLyTBResponse(ThanhLyTB thanhLyTB);
}
