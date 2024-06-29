package com.qltb.service;

import com.qltb.entity.ChiTietKiemKe;
import com.qltb.entity.ChiTietKiemKeKey;
import com.qltb.mapper.ChiTietKiemKeMapper;
import com.qltb.mapper.ChitietGiamTBMapper;
import com.qltb.model.request.create.CreateChiTietKiemKeRequest;
import com.qltb.model.request.update.UpdateChiTietKiemKeRequest;
import com.qltb.model.response.ChiTietGiamTBResponse;
import com.qltb.model.response.ChiTietKiemKeResponse;
import com.qltb.repository.ChiTietKiemKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietKiemKeService {
    @Autowired
    ChiTietKiemKeRepository chiTietKiemKeRepository;
    @Autowired
    ChiTietKiemKeMapper chiTietKiemKeMapper;

    public void delete(ChiTietKiemKeKey maKiemKe) {
        chiTietKiemKeRepository.deleteById(maKiemKe);
    }

    public ChiTietKiemKeResponse getById(ChiTietKiemKeKey maKiemKe) {
        ChiTietKiemKe chiTietKiemKe = chiTietKiemKeRepository.findById(maKiemKe)
                .orElseThrow(() -> new RuntimeException("Chi tiết kiểm kê not found"));
        return chiTietKiemKeMapper.toChiTietKiemKeResponse(chiTietKiemKe);
    }

    public ChiTietKiemKeResponse create(CreateChiTietKiemKeRequest request) {
        ChiTietKiemKe chiTietKiemKe = chiTietKiemKeMapper.toChiTietKiemKe(request);
        chiTietKiemKeRepository.save(chiTietKiemKe);
        return chiTietKiemKeMapper.toChiTietKiemKeResponse(chiTietKiemKe);
    }

    public ChiTietKiemKeResponse update(ChiTietKiemKeKey maKiemKe, UpdateChiTietKiemKeRequest request) {
        ChiTietKiemKe chiTietKiemKe1 = chiTietKiemKeRepository.findById(maKiemKe)
                .orElseThrow(() -> new RuntimeException("Chi tiết kiểm kê not found"));
        chiTietKiemKeMapper.updateChiTietKiemKe(chiTietKiemKe1, request);
        chiTietKiemKeRepository.save(chiTietKiemKe1);
        return chiTietKiemKeMapper.toChiTietKiemKeResponse(chiTietKiemKe1);
    }

    public List<ChiTietKiemKeResponse> getAll() {
        return chiTietKiemKeRepository.findAll().stream()
                .map(chiTietKiemKeMapper::toChiTietKiemKeResponse)
                .toList();
    }

}
