package com.qltb.service;

import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.ChiTietTangTBKey;
import com.qltb.mapper.ChiTietTangTBMapper;
import com.qltb.model.request.create.CreateChiTietTangTBRequest;
import com.qltb.model.request.update.UpdateChiTietTangTBRequest;
import com.qltb.model.response.ChiTietTangTBResponse;
import com.qltb.repository.ChiTietTangTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietTangTBService {
    @Autowired
    private ChiTietTangTBRepository chiTietTangTBRepository;
    @Autowired
    private ChiTietTangTBMapper chiTietTangTBMapper;

    public void delete(ChiTietTangTBKey maTangTB) {
        chiTietTangTBRepository.deleteById(maTangTB);
    }

    public List<ChiTietTangTBResponse> getAll() {
        return chiTietTangTBRepository.findAll().stream()
                .map(chiTietTangTBMapper::toChiTietTangTBResponse)
                .toList();
    }

    public ChiTietTangTBResponse getById(ChiTietTangTBKey maTangTB) {
        return chiTietTangTBMapper.toChiTietTangTBResponse(chiTietTangTBRepository.findById(maTangTB)
                .orElseThrow(() -> new RuntimeException("Chi tiết tầng thiết bị not found")));
    }

    public ChiTietTangTBResponse create(CreateChiTietTangTBRequest request) {
        ChiTietTangTB chiTietTangTB = chiTietTangTBMapper.toChiTietTangTB(request);
        chiTietTangTBRepository.save(chiTietTangTB);
        return chiTietTangTBMapper.toChiTietTangTBResponse(chiTietTangTB);
    }

    public ChiTietTangTBResponse update(ChiTietTangTBKey maTangTB, UpdateChiTietTangTBRequest request) {
        ChiTietTangTB chiTietTangTB = chiTietTangTBRepository.findById(maTangTB)
                .orElseThrow(() -> new RuntimeException("Chi tiết tầng thiết bị not found"));
        chiTietTangTBMapper.updateChiTietTangTB(chiTietTangTB, request);
        chiTietTangTBRepository.save(chiTietTangTB);
        return chiTietTangTBMapper.toChiTietTangTBResponse(chiTietTangTB);
    }
}
