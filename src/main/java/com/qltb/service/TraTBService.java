package com.qltb.service;

import com.qltb.entity.TraTB;
import com.qltb.mapper.TraTBMapper;
import com.qltb.model.request.create.CreateTraTBRequest;
import com.qltb.model.request.update.UpdateTraTBRequest;
import com.qltb.model.response.TraTBResponse;
import com.qltb.repository.TraTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraTBService {
    @Autowired
    TraTBRepository traTBRepository;
    @Autowired
    TraTBMapper traTBMapper;

    public TraTBResponse createTraTB(CreateTraTBRequest request) {
        TraTB traTB = traTBMapper.toTraTB(request);
        traTBRepository.save(traTB);
        return traTBMapper.toTraTBResponse(traTB);
    }

    public void deleteTraTB(String id) {
        traTBRepository.deleteById(id);
    }

    public void updateTraTB(String id, UpdateTraTBRequest request) throws Exception {
        TraTB traTB = traTBRepository.findById(id).orElseThrow(() -> new Exception("TraTB not found"));
        traTBMapper.updateTraTB(traTB, request);
        traTBRepository.save(traTB);
    }

    public List<TraTBResponse> getTraTBs() {
        List<TraTB> traTBs = traTBRepository.findAll();
        return traTBs.stream().map(traTBMapper::toTraTBResponse).toList();
    }
}
