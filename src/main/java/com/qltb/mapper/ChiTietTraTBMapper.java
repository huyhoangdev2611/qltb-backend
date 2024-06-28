package com.qltb.mapper;

import com.qltb.entity.ChiTietTraTB;
import com.qltb.model.request.create.CreateChiTietTraTBRequest;
import com.qltb.model.request.update.UpdateChiTietTraTBRequest;
import com.qltb.model.response.ChiTietTraTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChiTietTraTBMapper {
    ChiTietTraTB toChiTietTraTB(CreateChiTietTraTBRequest request);
    void updateChiTietTraTB(@MappingTarget ChiTietTraTB chiTietTraTB, UpdateChiTietTraTBRequest request);
    ChiTietTraTBResponse toChiTietTraTBResponse(ChiTietTraTB chiTietTraTB);
}
