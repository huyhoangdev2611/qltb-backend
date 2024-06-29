package com.qltb.service;

import com.qltb.entity.MuonTB;
import com.qltb.mapper.MuonTBMapper;
import com.qltb.model.request.create.CreateMuonTBRequest;
import com.qltb.model.request.update.UpdateMuonTBRequest;
import com.qltb.model.response.MuonTBResponse;
import com.qltb.repository.MuonTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuonTBService {
    @Autowired
    private MuonTBRepository muonTBRepository;
    @Autowired
    private MuonTBMapper muonTBMapper;

    public MuonTBResponse createMuonTB(CreateMuonTBRequest request) {
        MuonTB muonTB = muonTBMapper.toMuonTB(request);
        muonTBRepository.save(muonTB);
        return muonTBMapper.toMuonTBResponse(muonTB);
    }

    public void deleteMuonTB(String id) {
        muonTBRepository.deleteById(id);
    }

    public MuonTBResponse updateMuonTB(String id, UpdateMuonTBRequest request) {
        MuonTB muonTB = muonTBRepository.findById(id).orElseThrow(() -> new RuntimeException("MuonTB not found"));
        muonTBMapper.updateMuonTB(muonTB, request);
        muonTBRepository.save(muonTB);
        return muonTBMapper.toMuonTBResponse(muonTB);
    }

    public MuonTBResponse getById(String id) {
        MuonTB muonTB = muonTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MuonTB not found"));
        return muonTBMapper.toMuonTBResponse(muonTB);
    }

    public List<MuonTBResponse> getMuonTBs() {
        List<MuonTB> muonTBs = muonTBRepository.findAll();
        return muonTBs.stream().map(muonTBMapper::toMuonTBResponse).toList();
    }
}
