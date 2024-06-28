package com.qltb.mapper;

import com.qltb.entity.ChiTietGiamTB;
import com.qltb.model.request.create.CreateChiTietGiamTBRequest;
import com.qltb.model.request.update.UpdateChiTietGiamTBRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChiTietGiamTBMapper {
    ChiTietGiamTB toChiTietGiamTB(CreateChiTietGiamTBRequest request);
    void updateChiTietGiamTB(@MappingTarget ChiTietGiamTB chiTietGiamTB, UpdateChiTietGiamTBRequest request);
    ChiTietGiamTBResponse toAnimeResponse(ChiTietGiamTB chiTietGiamTB);
}
