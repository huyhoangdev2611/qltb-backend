package com.qltb.mapper;

import com.qltb.entity.MuonTB;
import com.qltb.entity.TraTB;
import com.qltb.model.request.create.TraTBCreateRequest;
import com.qltb.model.response.TraTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TraTBMapper {
    TraTB toTraTB(TraTBCreateRequest request);

    @Mapping(target = "maPhieuMuon", source = "muonTB.maPhieuMuon")
    @Mapping(target = "tenGiaoVien", source = "muonTB.giaoVien.tenGV")
    @Mapping(target = "ngayMuon", source = "muonTB.ngayMuon")
    @Mapping(target = "ngayTra", source = "ngayTra")
    TraTBResponse toTraTBResponse(TraTB traTB);

    default void updateTraTBFromRequest(TraTBCreateRequest request, @MappingTarget TraTB traTB) {
        if (request.getMaPhieuMuon() != null) {
            MuonTB muonTB = new MuonTB();
            muonTB.setMaPhieuMuon(request.getMaPhieuMuon());
            traTB.setMuonTB(muonTB);
        }
        traTB.setNgayTra(request.getNgayTra());
    }
}
