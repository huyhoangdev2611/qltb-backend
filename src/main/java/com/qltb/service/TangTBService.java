package com.qltb.service;

import com.qltb.entity.TangTB;
import com.qltb.mapper.TangTBMapper;
import com.qltb.model.request.create.CreateTangTBRequest;
import com.qltb.model.request.update.UpdateTangTBRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.repository.TangTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TangTBService {
    @Autowired
    private TangTBRepository tangTBRepository;
    @Autowired
    private TangTBMapper tangTBMapper;

    public void deleteTangTB(String id) {
        tangTBRepository.deleteById(id);
    }

    public List<TangTBResponse> getTangTBs() {
        List<TangTB> tangTBs = tangTBRepository.findAll();
        return tangTBs.stream().map(tangTBMapper::toTangTBResponse).toList();
    }

    public TangTBResponse getById(String id) {
        TangTB tangTB = tangTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TangTB not found"));
        return tangTBMapper.toTangTBResponse(tangTB);
    }

    public TangTBResponse createTangTB(CreateTangTBRequest request) {
        TangTB tangTB = tangTBRepository.save(tangTBMapper.toTangTB(request));
        return tangTBMapper.toTangTBResponse(tangTB);
    }

    public TangTBResponse updateTangTB(String id, UpdateTangTBRequest request) {
        TangTB tangTB = tangTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TangTB not found"));
        tangTBMapper.updateTangTB(tangTB, request);
        tangTBRepository.save(tangTB);
        return tangTBMapper.toTangTBResponse(tangTB);
    }
}
