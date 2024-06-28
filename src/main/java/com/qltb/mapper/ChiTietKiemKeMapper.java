package com.qltb.mapper;

import com.qltb.entity.ChiTietGiamTB;
import com.qltb.entity.ChiTietKiemKe;
import com.qltb.model.request.create.CreateChiTietGiamTBRequest;
import com.qltb.model.request.create.CreateChiTietKiemKeRequest;
import com.qltb.model.request.update.UpdateChiTietGiamTBRequest;
import com.qltb.model.request.update.UpdateChiTietKiemKeRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import com.qltb.model.response.ChiTietKiemKeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChiTietKiemKeMapper {
    ChiTietKiemKe toChiTietKiemKe(CreateChiTietKiemKeRequest request);
    void updateChiTietKiemKe(@MappingTarget ChiTietKiemKe chiTietKiemKe, UpdateChiTietKiemKeRequest request);
    ChiTietKiemKeResponse toChiTietKiemKeResponse(ChiTietKiemKe chiTietKiemKe);
}
