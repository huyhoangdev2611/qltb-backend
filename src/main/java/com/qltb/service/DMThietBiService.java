package com.qltb.service;

import com.qltb.entity.DMThietBi;
import com.qltb.mapper.DMThietBiMapper;
import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import com.qltb.repository.DMThietBiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DMThietBiService {
    @Autowired
    private DMThietBiRepository dmThietBiRepository;

    @Autowired
    private DMThietBiMapper dmThietBiMapper;

    public DMThietBiResponse create(CreateDMThietBiRequest request) {
        DMThietBi dmThietBi = dmThietBiMapper.toDMThietBi(request);
        dmThietBi.setMaTB(generateMaTB());
        dmThietBiRepository.save(dmThietBi);
        return dmThietBiMapper.toDMThietBiResponse(dmThietBi);
    }

    public DMThietBiResponse update(String maTB, UpdateDMThietBiRequest request) {
        DMThietBi dmThietBi = dmThietBiRepository.findById(maTB)
                .orElseThrow(() -> new RuntimeException("Thiết bị không được tìm thấy"));
        dmThietBiMapper.updateDMThietBi(dmThietBi, request);
        dmThietBiRepository.save(dmThietBi);
        return dmThietBiMapper.toDMThietBiResponse(dmThietBi);
    }

    public void delete(String maTB) {
        dmThietBiRepository.deleteById(maTB);
    }

    public DMThietBiResponse getById(String maTB) {
        DMThietBi dmThietBi = dmThietBiRepository.findById(maTB)
                .orElseThrow(() -> new RuntimeException("Thiết bị không được tìm thấy"));
        return dmThietBiMapper.toDMThietBiResponse(dmThietBi);
    }

    public List<DMThietBiResponse> getAll() {
        return dmThietBiRepository.findAll().stream()
                .map(dmThietBiMapper::toDMThietBiResponse)
                .collect(Collectors.toList());
    }

    private String generateMaTB() {
        Optional<DMThietBi> lastDMThietBi = dmThietBiRepository.findTopByOrderByMaTBDesc();
        if (lastDMThietBi.isPresent()) {
            String lastMaTB = lastDMThietBi.get().getMaTB();
            int nextId = Integer.parseInt(lastMaTB.substring(2)) + 1;
            return String.format("TB%05d", nextId);
        } else {
            return "TB00001";
        }
    }
}
