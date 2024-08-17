package com.qltb.mapper;

import com.qltb.entity.ThietBi;
import com.qltb.model.request.create.ThietBiCreateRequest;
import com.qltb.model.response.ThietBiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThietBiMapper {
    ThietBi toThietBi(ThietBiCreateRequest request);

    @Mapping(target = "khoPhong", source = "thietBi.khoPhong.tenKP")
    @Mapping(target = "tenNTB", source = "thietBi.nhomThietBi.tenNTB")
    @Mapping(target = "thietBiTieuHao", source = "thietBi.nhomThietBi.tbTieuHao")
    ThietBiResponse toThietBiResponse(ThietBi thietBi);
}
