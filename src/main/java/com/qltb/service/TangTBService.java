package com.qltb.service;

import com.qltb.entity.ChiTietGiamTB;
import com.qltb.entity.ChiTietTangTB;
import com.qltb.entity.DSThietBi;
import com.qltb.entity.TangTB;
import com.qltb.mapper.ChiTietTangTBMapper;
import com.qltb.mapper.TangTBMapper;
import com.qltb.model.request.create.CreateChiTietTangTBRequest;
import com.qltb.model.request.create.CreateTangTBRequest;
import com.qltb.model.request.update.UpdateTangTBRequest;
import com.qltb.model.response.TangTBResponse;
import com.qltb.repository.ChiTietTangTBRepository;
import com.qltb.repository.DMThietBiRepository;
import com.qltb.repository.DSThietBiRepository;
import com.qltb.repository.TangTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TangTBService {
    @Autowired
    private TangTBRepository tangTBRepository;
    @Autowired
    private TangTBMapper tangTBMapper;
    @Autowired
    private ChiTietTangTBMapper chiTietTangTBMapper;
    @Autowired
    private ChiTietTangTBRepository chiTietTangTBRepository;
    @Autowired
    private DSThietBiRepository dsThietBiRepository;
    @Autowired
    private DMThietBiRepository dmThietBiRepository;

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
        TangTB tangTB = tangTBMapper.toTangTB(request);
        tangTB.setMaPhieuTang(generateMaPhieuTang());
        tangTB = tangTBRepository.save(tangTB);
        String maPhieuTang = tangTB.getMaPhieuTang();
        tangTB.setChiTietTangTBs(new ArrayList<ChiTietTangTB>());
        for (CreateChiTietTangTBRequest chiTietTangTBRequest : request.getChiTietTangTBs()) {
            ChiTietTangTB chiTietTangTB = chiTietTangTBMapper.toChiTietTangTB(chiTietTangTBRequest);
            chiTietTangTB.setMaPhieuTang(maPhieuTang);
            chiTietTangTBRepository.save(chiTietTangTB);

            DSThietBi dsThietBi = dsThietBiRepository.findDSThietBiByMaTBAndMaKP(chiTietTangTB.getMaTB(), chiTietTangTB.getMaKP());
            if (dsThietBi != null) {
                dsThietBi.setTrongKho(dsThietBi.getTrongKho() + chiTietTangTB.getSoLuong());
                dsThietBi.setSoLuong(dsThietBi.getSoLuong() + chiTietTangTB.getSoLuong());
            } else {
                dsThietBi = DSThietBi.builder()
                        .maTB(chiTietTangTB.getMaTB())
                        .maKP(chiTietTangTB.getMaKP())
                        .trongKho(chiTietTangTB.getSoLuong())
                        .mat(0)
                        .hong(0)
                        .soLuong(chiTietTangTB.getSoLuong())
                        .tenTB(dmThietBiRepository.findById(chiTietTangTB.getMaTB()).get().getTenTB())
                        .build();
            }
            dsThietBiRepository.save(dsThietBi);

        }
        tangTB = tangTBRepository.save(tangTB);
        return tangTBMapper.toTangTBResponse(tangTB);
    }

    public TangTBResponse updateTangTB(String id, UpdateTangTBRequest request) {
        TangTB tangTB = tangTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TangTB not found"));
        tangTBMapper.updateTangTB(tangTB, request);
        tangTBRepository.save(tangTB);
        return tangTBMapper.toTangTBResponse(tangTB);
    }

    private String generateMaPhieuTang() {
        Optional<TangTB> lastGiaoVien = tangTBRepository.findTopByOrderByMaPhieuTangDesc();
        if (lastGiaoVien.isPresent()) {
            String lastMaGV = lastGiaoVien.get().getMaPhieuTang();
            int nextId = Integer.parseInt(lastMaGV.substring(2)) + 1;
            return String.format("PT%05d", nextId);
        } else {
            return "GT00001";
        }
    }
}
