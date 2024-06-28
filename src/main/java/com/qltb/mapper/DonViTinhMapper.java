package com.qltb.mapper;

import com.qltb.entity.DonViTinh;
import com.qltb.model.request.create.CreateDonViTinhRequest;
import com.qltb.model.request.update.UpdateDonViTinhRequest;
import com.qltb.model.response.DonViTinhResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DonViTinhMapper {
    DonViTinh toDonViTinh(CreateDonViTinhRequest request);
    void updateDonViTinh(@MappingTarget DonViTinh donViTinh, UpdateDonViTinhRequest request);
    DonViTinhResponse toDonViTinhResponse(DonViTinh donViTinh);
}
