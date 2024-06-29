package com.qltb.service;

import com.qltb.entity.ChiTietGiamTB;
import com.qltb.mapper.ChitietGiamTBMapper;
import com.qltb.model.request.create.CreateChiTietGiamTBRequest;
import com.qltb.model.request.update.UpdateChiTietGiamTBRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import com.qltb.repository.ChiTietGiamTBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietGiamTBService {
    @Autowired
    ChitietGiamTBMapper chitietGiamTBMapper;
    @Autowired
    ChiTietGiamTBRepository chiTietGiamTBRepository;

    public ChiTietGiamTBResponse create(CreateChiTietGiamTBRequest request) {
        ChiTietGiamTB chiTietGiamTB = chitietGiamTBMapper.toChiTietGiamTB(request);
        chiTietGiamTBRepository.save(chiTietGiamTB);
        return chitietGiamTBMapper.toChiTietGiamTBResponse(chiTietGiamTB);
    }

    public ChiTietGiamTBResponse update(String maGiamTB, UpdateChiTietGiamTBRequest request) {
        ChiTietGiamTB chiTietGiamTB = chiTietGiamTBRepository.findById(maGiamTB)
                .orElseThrow(() -> new RuntimeException("Chi tiết giảm thiết bị not found"));
        chitietGiamTBMapper.updateChiTietGiamTB(chiTietGiamTB, request);
        chiTietGiamTBRepository.save(chiTietGiamTB);
        return chitietGiamTBMapper.toChiTietGiamTBResponse(chiTietGiamTB);
    }

    public ChiTietGiamTBResponse getById(String maGiamTB) {
        ChiTietGiamTB chiTietGiamTB = chiTietGiamTBRepository.findById(maGiamTB)
                .orElseThrow(() -> new RuntimeException("Chi tiết giảm thiết bị not found"));
        return chitietGiamTBMapper.toChiTietGiamTBResponse(chiTietGiamTB);
    }

    public List<ChiTietGiamTBResponse> getAll() {
        return chiTietGiamTBRepository.findAll().stream()
                .map(chitietGiamTBMapper::toChiTietGiamTBResponse)
                .toList();
    }

    public void delete(String maGiamTB) {
        chiTietGiamTBRepository.deleteById(maGiamTB);
    }
}
