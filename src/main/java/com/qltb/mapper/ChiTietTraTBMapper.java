package com.qltb.mapper;

import com.qltb.entity.ChiTietTraTB;
import com.qltb.model.request.create.ChiTietTraTBCreateRequest;
import com.qltb.model.response.ChiTietTraTBResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChiTietTraTBMapper {
    ChiTietTraTB toChiTietTraTB(ChiTietTraTBCreateRequest request);
    ChiTietTraTBResponse toChiTietTraTBResponse(ChiTietTraTB chiTietTraTB);
}
