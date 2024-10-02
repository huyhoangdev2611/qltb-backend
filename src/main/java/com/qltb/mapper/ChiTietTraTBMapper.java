package com.qltb.mapper;

import com.qltb.entity.ChiTietTraTB;
import com.qltb.model.request.create.ChiTietTraTBCreateRequest;
import com.qltb.model.response.ChiTietTraTBResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChiTietTraTBMapper {
    ChiTietTraTB toChiTietTraTB(ChiTietTraTBCreateRequest request);

    @Mapping(target = "maCaBietTB", source = "thietBi.maCaBietTB")
    @Mapping(target = "tenNTB", source = "thietBi.nhomThietBi.tenNTB")  // Lấy tên thiết bị từ NhomThietBi
    @Mapping(target = "tinhTrang", source = "thietBi.tinhTrang")  // Lấy tình trạng khi mượn từ ThietBi
    @Mapping(target = "thietBiTieuHao", source = "thietBi.nhomThietBi.tbTieuHao")  // Lấy thietBiTieuHao từ ThietBi
    ChiTietTraTBResponse toChiTietTraTBResponse(ChiTietTraTB chiTietTraTB);
}
