package com.qltb.mapper;

import com.qltb.entity.ChiTietMuonTB;
import com.qltb.model.request.create.ChiTietMuonTBCreateRequest;
import com.qltb.model.response.ChiTietMuonTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChiTietMuonTBMapper {
    ChiTietMuonTB toChiTietMuonTB(ChiTietMuonTBCreateRequest request);
    @Mapping(target = "tenThietBi", source = "thietBi.nhomThietBi.tenNTB")
    ChiTietMuonTBResponse toChiTietMuonTBResponse(ChiTietMuonTB chiTietMuonTB);

}
