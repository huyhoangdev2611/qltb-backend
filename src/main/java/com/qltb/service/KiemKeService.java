package com.qltb.service;

import com.qltb.entity.KiemKe;
import com.qltb.mapper.KiemKeMapper;
import com.qltb.model.request.create.CreateKiemKeRequest;
import com.qltb.model.request.update.UpdateKiemKeRequest;
import com.qltb.model.response.KiemKeResponse;
import com.qltb.repository.KiemKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiemKeService {
    @Autowired
    private KiemKeRepository kiemKeRepository;
    @Autowired
    private KiemKeMapper kiemKeMapper;

    public void deleteKiemKe(String id) {
        kiemKeRepository.deleteById(id);
    }

    public List<KiemKeResponse> getKiemKes() {
        List<KiemKe> kiemKes = kiemKeRepository.findAll();
        return kiemKes.stream().map(kiemKeMapper::toKiemKeResponse).toList();
    }

    public KiemKeResponse getById(String id) {
        KiemKe kiemKe = kiemKeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KiemKe not found"));
        return kiemKeMapper.toKiemKeResponse(kiemKe);
    }

    public KiemKeResponse createKiemKe(CreateKiemKeRequest request) {
        KiemKe kiemKe = kiemKeRepository.save(kiemKeMapper.toKiemKe(request));
        return kiemKeMapper.toKiemKeResponse(kiemKe);
    }

    public KiemKeResponse updateKiemKe(String id, UpdateKiemKeRequest request) {
        KiemKe kiemKe = kiemKeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KiemKe not found"));
        kiemKeMapper.updateKiemKe(kiemKe, request);
        kiemKeRepository.save(kiemKe);
        return kiemKeMapper.toKiemKeResponse(kiemKe);
    }
}
