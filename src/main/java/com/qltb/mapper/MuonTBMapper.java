package com.qltb.mapper;

import com.qltb.entity.MuonTB;
import com.qltb.model.request.create.MuonTBCreateRequest;
import com.qltb.model.response.MuonTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MuonTBMapper {
    MuonTB toMuonTB(MuonTBCreateRequest request);

    @Mapping(target = "giaoVien", source = "giaoVien.tenGV", qualifiedByName = "getTenGiaoVien")
    @Mapping(target = "chiTietMuonTBList", source = "chiTietMuonTBList")
    MuonTBResponse toMuonTBResponse(MuonTB muonTB);

    @Named("getTenGiaoVien")
    default String getTenGiaoVien(String tenGV) {
        return tenGV;
    }
}
