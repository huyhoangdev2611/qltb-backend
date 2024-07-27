package com.qltb.service;

import com.qltb.entity.NhomThietBi;
import com.qltb.mapper.NhomThietBiMapper;
import com.qltb.model.request.create.NhomThietBiCreateRequest;
import com.qltb.model.request.update.NhomThietBiUpdateRequest;
import com.qltb.model.response.NhomThietBiResponse;
import com.qltb.repository.NhomThietBiRepository;
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
public class NhomThietBiService {
    @Autowired
    NhomThietBiRepository nhomThietBiRepository;
    @Autowired
    NhomThietBiMapper nhomThietBiMapper;
    @Autowired
    LoaiTBRepository loaiTBRepository;
    @Autowired
    MonHocRepository monHocRepository;
    @Autowired
    DonViTinhRepository donViTinhRepository;

    public NhomThietBiResponse create(NhomThietBiCreateRequest request) {
        NhomThietBi dmThietBi = nhomThietBiMapper.toNhomThietBi(request);
        dmThietBi.setMaNTB(generateMaNTB());
        nhomThietBiRepository.save(dmThietBi);
        return nhomThietBiMapper.toNhomThietBiResponse(dmThietBi);
    }

    public NhomThietBiResponse update(String maTB, NhomThietBiUpdateRequest request) {
        NhomThietBi dmThietBi = nhomThietBiRepository.findById(maTB)
                .orElseThrow(() -> new RuntimeException("Thiết bị không được tìm thấy"));
        nhomThietBiMapper.updateNhomThietBi(dmThietBi, request);
        nhomThietBiRepository.save(dmThietBi);
        return nhomThietBiMapper.toNhomThietBiResponse(dmThietBi);
    }

    public void delete(String maTB) {
        nhomThietBiRepository.deleteById(maTB);
    }

    public NhomThietBiResponse getById(String maNTB) {
        NhomThietBi dmThietBi = nhomThietBiRepository.findById(maNTB)
                .orElseThrow(() -> new RuntimeException("Thiết bị không được tìm thấy"));
        return nhomThietBiMapper.toNhomThietBiResponse(dmThietBi);
    }

    public List<NhomThietBiResponse> getAll() {
        return nhomThietBiRepository.findAll().stream()
                .map(this::apply)
                .sorted(Comparator.comparing(NhomThietBiResponse::getMaNTB))
                .collect(Collectors.toList());
    }

    public Page<NhomThietBiResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maNTB"));
        return nhomThietBiRepository.findAll(pageable).map(this::apply);
    }

    public Page<NhomThietBiResponse> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhomThietBiRepository.findByTenNTBContainingIgnoreCaseOrderByMaNTB(pageable, name).map(this::apply);
    }

    public List<NhomThietBiResponse> searchByName(String name) {
        return nhomThietBiRepository.findByTenNTBContainingIgnoreCase(name).stream().map(this::apply).toList();
    }

//    public List<NhomThietBiResponse> getInDSThietbi() {
//        return nhomThietBiRepository.getInDSThietBi().stream().map(this::apply).toList();
//    }

    private String generateMaNTB() {
        Optional<NhomThietBi> lastDMThietBi = nhomThietBiRepository.findTopByOrderByMaNTBDesc();
        if (lastDMThietBi.isPresent()) {
            String lastMaTB = lastDMThietBi.get().getMaNTB();
            int nextId = Integer.parseInt(lastMaTB.substring(2)) + 1;
            return String.format("TB%05d", nextId);
        } else {
            return "TB00001";
        }
    }

    private NhomThietBiResponse apply(NhomThietBi dmThietBi) {
        NhomThietBiResponse dmThietBiResponse = nhomThietBiMapper.toNhomThietBiResponse(dmThietBi);
        dmThietBiResponse.setLoaiTB(String.valueOf(loaiTBRepository.findById(dmThietBi.getMaLoaiTB()).get().getTenLoaiTB()));
        dmThietBiResponse.setTenMonHoc(String.valueOf(monHocRepository.findById(dmThietBi.getMaMonHoc()).get().getTenMonHoc()));
        dmThietBiResponse.setDonViTinh(String.valueOf(donViTinhRepository.findById(dmThietBi.getMaDVT()).get().getTenDVT()));
        dmThietBiResponse.setMaDVT(dmThietBi.getMaDVT());
        return dmThietBiResponse;
    }
}