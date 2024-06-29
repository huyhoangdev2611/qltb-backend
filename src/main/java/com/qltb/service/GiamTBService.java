package com.qltb.service;

import com.qltb.entity.GiamTB;
import com.qltb.mapper.GiamTBMapper;
import com.qltb.model.request.create.CreateGiamTBRequest;
import com.qltb.model.request.update.UpdateGiamTBRequest;
import com.qltb.model.response.GiamTBResponse;
import com.qltb.repository.GiamTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiamTBService {
    @Autowired
    private GiamTBRepository giamTBRepository;
    @Autowired
    private GiamTBMapper giamTBMapper;

    public void deleteGiamTB(String id) {
        giamTBRepository.deleteById(id);
    }

    public List<GiamTBResponse> getGiamTBs() {
        List<GiamTB> giamTBs = giamTBRepository.findAll();
        return giamTBs.stream().map(giamTBMapper::toGiamTBResponse).toList();
    }

    public GiamTBResponse getById(String id) {
        GiamTB giamTB = giamTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GiamTB not found"));
        return giamTBMapper.toGiamTBResponse(giamTB);
    }

    public GiamTBResponse createGiamTB(CreateGiamTBRequest request) {
        GiamTB giamTB = giamTBRepository.save(giamTBMapper.toGiamTB(request));
        return giamTBMapper.toGiamTBResponse(giamTB);
    }

    public GiamTBResponse updateGiamTB(String id, UpdateGiamTBRequest request) {
        GiamTB giamTB = giamTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GiamTB not found"));
        giamTBMapper.updateGiamTB(giamTB, request);
        giamTBRepository.save(giamTB);
        return giamTBMapper.toGiamTBResponse(giamTB);
    }

}
