package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.mapper.GiaoVienMapper;
import com.qltb.model.request.create.CreateGiaoVienRequest;
import com.qltb.model.request.update.UpdateGiaoVienRequest;
import com.qltb.model.response.GiaoVienResponse;
import com.qltb.repository.GiaoVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GiaoVienService {
    @Autowired
    private GiaoVienRepository giaoVienRepository;

    @Autowired
    private GiaoVienMapper giaoVienMapper;

    public GiaoVienResponse create(CreateGiaoVienRequest request) {
        GiaoVien giaoVien = giaoVienMapper.toGiaoVien(request);
        giaoVien.setMaGV(generateMaGV());
        giaoVienRepository.save(giaoVien);
        return giaoVienMapper.toGiaoVienResponse(giaoVien);
    }

    public GiaoVienResponse update(String maGV, UpdateGiaoVienRequest request) {
        GiaoVien giaoVien = giaoVienRepository.findById(maGV)
                .orElseThrow(() -> new RuntimeException("Giao vien not found"));
        giaoVienMapper.updateGiaoVien(giaoVien, request);
        giaoVienRepository.save(giaoVien);
        return giaoVienMapper.toGiaoVienResponse(giaoVien);
    }

    public void delete(String maGV) {
        giaoVienRepository.deleteById(maGV);
    }

    public GiaoVienResponse getById(String maGV) {
        GiaoVien giaoVien = giaoVienRepository.findById(maGV)
                .orElseThrow(() -> new RuntimeException("Giao vien not found"));
        return giaoVienMapper.toGiaoVienResponse(giaoVien);
    }

    public List<GiaoVienResponse> getAll() {
        return giaoVienRepository.findAll().stream()
                .map(giaoVienMapper::toGiaoVienResponse)
                .collect(Collectors.toList());
    }

    public Page<GiaoVienResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return giaoVienRepository.findAll(pageable).map(giaoVienMapper::toGiaoVienResponse);

    }

    private String generateMaGV() {
        Optional<GiaoVien> lastGiaoVien = giaoVienRepository.findTopByOrderByMaGVDesc();
        if (lastGiaoVien.isPresent()) {
            String lastMaGV = lastGiaoVien.get().getMaGV();
            int nextId = Integer.parseInt(lastMaGV.substring(2)) + 1;
            return String.format("GV%05d", nextId);
        } else {
            return "GV00001";
        }
    }
}
