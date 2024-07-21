package com.qltb.service;

import com.qltb.entity.DSThietBi;
import com.qltb.entity.DSThietBiKey;
import com.qltb.entity.KhoPhong;
import com.qltb.mapper.DSThietBiMapper;
import com.qltb.model.request.create.CreateDSThietBiRequest;
import com.qltb.model.response.DSThietBiResponse;
import com.qltb.model.response.KhoPhongResponse;
import com.qltb.repository.DSThietBiRepository;
import com.qltb.repository.KhoPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class DSThietBiService {
    @Autowired
    private DSThietBiRepository dsThietBiRepository;
    @Autowired
    private DSThietBiMapper dsThietBiMapper;
    @Autowired
    private KhoPhongRepository khoPhongRepository;

    public DSThietBiResponse create(CreateDSThietBiRequest request) throws Exception {
        if (dsThietBiRepository.existsByMaTBAndMaKP(request.getMaTB(), request.getMaKP())) {
            throw new Exception("DSThietBi da ton tai");
        }
        DSThietBi dsThietBi = dsThietBiMapper.toDSThietBi(request);
        dsThietBi.setTrongKho(request.getSoLuong());
        return dsThietBiMapper.toDSThietBiResponse(dsThietBiRepository.save(dsThietBi));
    }

    public Page<DSThietBiResponse> getDSThietBi(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maTB"));
        return dsThietBiRepository.findAll(pageable).map(dsThietBi -> {
            DSThietBiResponse dsThietBiResponse = dsThietBiMapper.toDSThietBiResponse(dsThietBi);
            dsThietBiResponse.setTenKP(Objects.requireNonNull(khoPhongRepository.findById(dsThietBi.getMaKP()).orElse(null)).getTenKP());
            dsThietBiResponse.setSoLuong(dsThietBiRepository.sumSoLuongByMaTB(dsThietBi.getMaTB()));
            return dsThietBiResponse;
        });
    }

    public Page<DSThietBiResponse> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dsThietBiRepository.findByTenTBContainingIgnoreCaseOrderByMaTBAsc(pageable, name).map(dsThietBi -> {
            DSThietBiResponse dsThietBiResponse = dsThietBiMapper.toDSThietBiResponse(dsThietBi);
            dsThietBiResponse.setTenKP(Objects.requireNonNull(khoPhongRepository.findById(dsThietBi.getMaKP()).orElse(null)).getTenKP());
            dsThietBiResponse.setSoLuong(dsThietBiRepository.sumSoLuongByMaTB(dsThietBi.getMaTB()));
            return dsThietBiResponse;
        });
    }

    public List<DSThietBiResponse> getDistinctByMaTB() {
        List<DSThietBi> dsThietBiList = dsThietBiRepository.getDistinctByMaTB();
        return dsThietBiList.stream().map(dsThietBiMapper::toDSThietBiResponse).toList();
    }

    public List<KhoPhongResponse> findKhoPhongByMaTB(String maTB) {
        return dsThietBiRepository.findKhoPhongByMaTB(maTB);
    }

    public DSThietBiResponse findByMaTBAndMaKP(String maTB, String maKP) {
        DSThietBi dsThietBi = dsThietBiRepository.findDSThietBiByMaTBAndMaKP(maTB, maKP);
        return dsThietBiMapper.toDSThietBiResponse(dsThietBi);
    }

    public List<DSThietBiResponse> getAll() {
        return dsThietBiRepository.findAll().stream()
                .map(dsThietBiMapper::toDSThietBiResponse)
                .toList();
    }
}
