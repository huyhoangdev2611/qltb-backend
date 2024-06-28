package com.qltb.mapper;

import com.qltb.entity.MuonTB;
import com.qltb.model.request.create.CreateMuonTBRequest;
import com.qltb.model.request.update.UpdateMuonTBRequest;
import com.qltb.model.response.MuonTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MuonTBMapper {
    MuonTB toMuonTB(CreateMuonTBRequest request);
    void updateMuonTB(@MappingTarget MuonTB muonTB, UpdateMuonTBRequest request);
    MuonTBResponse toMuonTBResponse(MuonTB muonTB);
}
