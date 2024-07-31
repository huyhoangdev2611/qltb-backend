package com.qltb.mapper;

import com.qltb.entity.TheoDoiHongMat;
import com.qltb.model.request.create.TheoDoiHongMatCreateRequest;
import com.qltb.model.response.TheoDoiHongMatResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TheoDoiHongMatMapper {
    TheoDoiHongMat toTheoDoiHongMat(TheoDoiHongMatCreateRequest request);

    @Mapping(target = "tenTB", source = "thietBi.nhomThietBi.tenNTB")
    @Mapping(target = "khoPhong", source = "thietBi.khoPhong.tenKP")
    TheoDoiHongMatResponse toTheoDoiHongMatResponse(TheoDoiHongMat theoDoiHongMat);
}
