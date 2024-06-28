package com.qltb.mapper;

import com.qltb.entity.ChiTietMuonTB;
import com.qltb.model.request.create.CreateChiTietMuonTBRequest;
import com.qltb.model.request.update.UpdateChiTietMuonTBRequest;
import com.qltb.model.response.ChiTietMuonTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChiTietMuonTBMapper {
    ChiTietMuonTB toChiTietMuonTB(CreateChiTietMuonTBRequest request);
    void updateChiTietMuonTB(@MappingTarget ChiTietMuonTB chiTietMuonTB, UpdateChiTietMuonTBRequest request);
    ChiTietMuonTBResponse toChiTietMuonTBResponse(ChiTietMuonTB chiTietMuonTB);
}
