package com.qltb.mapper;

import com.qltb.entity.TheoDoiHongMat;
import com.qltb.model.request.create.CreateTheoDoiHongMatRequest;
import com.qltb.model.request.update.UpdateTheoDoiHongMatRequest;
import com.qltb.model.response.TheoDoiHongMatResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TheoDoiHongMatMapper {
    TheoDoiHongMat toTheoDoiHongMat(CreateTheoDoiHongMatRequest request);
    void updateTheoDoiHongMat(@MappingTarget TheoDoiHongMat theoDoiHongMat, UpdateTheoDoiHongMatRequest request);
    TheoDoiHongMatResponse toTheoDoiHongMatResponse(TheoDoiHongMat theoDoiHongMat);
}
