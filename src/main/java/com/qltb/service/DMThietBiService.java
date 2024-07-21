package com.qltb.service;

import com.qltb.controller.DMThietBiController;
import com.qltb.entity.DMThietBi;
import com.qltb.mapper.DMThietBiMapper;
import com.qltb.model.request.create.CreateDMThietBiRequest;
import com.qltb.model.request.update.UpdateDMThietBiRequest;
import com.qltb.model.response.DMThietBiResponse;
import com.qltb.model.response.GiaoVienResponse;
import com.qltb.repository.DMThietBiRepository;
import com.qltb.repository.DonViTinhRepository;
import com.qltb.repository.LoaiTBRepository;
import com.qltb.repository.MonHocRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class DMThietBiService {
    @Autowired
    DMThietBiRepository dmThietBiRepository;
    @Autowired
    DMThietBiMapper dmThietBiMapper;
    @Autowired
    LoaiTBRepository loaiTBRepository;
    @Autowired
    MonHocRepository monHocRepository;
    @Autowired
    DonViTinhRepository donViTinhRepository;

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
                .map(this::apply)
                .sorted(Comparator.comparing(DMThietBiResponse::getMaTB))
                .collect(Collectors.toList());
    }

    public Page<DMThietBiResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maTB"));
        return dmThietBiRepository.findAll(pageable).map(this::apply);
    }

    public Page<DMThietBiResponse> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dmThietBiRepository.findByTenTBContainingIgnoreCaseOrderByMaTB(pageable, name).map(this::apply);
    }

    public List<DMThietBiResponse> searchByName(String name) {
        return dmThietBiRepository.findByTenTBContainingIgnoreCase(name).stream().map(this::apply).toList();
    }

    public List<DMThietBiResponse> getInDSThietbi() {
        return dmThietBiRepository.getInDSThietBi().stream().map(this::apply).toList();
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

    private DMThietBiResponse apply(DMThietBi dmThietBi) {
        DMThietBiResponse dmThietBiResponse = dmThietBiMapper.toDMThietBiResponse(dmThietBi);
        dmThietBiResponse.setLoaiTB(String.valueOf(loaiTBRepository.findById(dmThietBi.getMaLoaiTB()).get().getTenLoaiTB()));
        dmThietBiResponse.setTenMonHoc(String.valueOf(monHocRepository.findById(dmThietBi.getMaMonHoc()).get().getTenMonHoc()));
        dmThietBiResponse.setDonViTinh(String.valueOf(donViTinhRepository.findById(dmThietBi.getMaDVT()).get().getTenDVT()));
        return dmThietBiResponse;
    }
}
