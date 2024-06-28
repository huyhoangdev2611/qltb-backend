package com.qltb.mapper;

import com.qltb.entity.KiemKe;
import com.qltb.model.request.create.CreateKiemKeRequest;
import com.qltb.model.request.update.UpdateKiemKeRequest;
import com.qltb.model.response.KiemKeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KiemKeMapper {
    KiemKe toKiemKe(CreateKiemKeRequest request);
    void updateKiemKe(@MappingTarget KiemKe kiemKe, UpdateKiemKeRequest request);
    KiemKeResponse toKiemKeResponse(KiemKe kiemKe);
}
