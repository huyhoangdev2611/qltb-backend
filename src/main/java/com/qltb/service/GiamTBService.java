package com.qltb.service;

import com.qltb.entity.*;
import com.qltb.mapper.GiamTBMapper;
import com.qltb.model.request.create.CreateChiTietGiamTBRequest;
import com.qltb.model.request.create.CreateGiamTBRequest;
import com.qltb.model.request.update.UpdateGiamTBRequest;
import com.qltb.model.response.GiamTBResponse;
import com.qltb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiamTBService {
    @Autowired
    private GiamTBRepository giamTBRepository;
    @Autowired
    private GiamTBMapper giamTBMapper;
    @Autowired
    private ChiTietGiamTBRepository chiTietGiamTBRepository;
    @Autowired
    private DSThietBiRepository dsThietBiRepository;

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
        GiamTB giamTB = giamTBMapper.toGiamTB(request);
        giamTB.setMaPhieuGiam(generateMaPhieuGiam());
//        String maPhieuGiam = giamTB.getMaPhieuGiam();
//        giamTB.setChiTietGiamTBs(request.getChiTietGiamTBs().stream().map(chiTietGiamTBRequest -> {
//            System.out.println(chiTietGiamTBRequest);
//            return ChiTietGiamTB.builder()
//                    .id(new ChiTietGiamTBKey(chiTietGiamTBRequest.getMaTB(), chiTietGiamTBRequest.getMaKP(), maPhieuGiam))
//                    .slMat(0)
//                    .slHong(chiTietGiamTBRequest.getHong())
//                    .slConDungDuoc(chiTietGiamTBRequest.getConDungDuoc())
////                    .khoPhong(khoPhongRepository.findById(chiTietGiamTBRequest.getMaKP()).orElseThrow(() -> new RuntimeException("KhoPhong not found")))
//                    .build();
//        }).toList());
        giamTB = giamTBRepository.save(giamTB);
        giamTB.setChiTietGiamTBs(new ArrayList<ChiTietGiamTB>());
        for(CreateChiTietGiamTBRequest chiTietGiamTBRequest : request.getChiTietGiamTBs()) {
            ChiTietGiamTB chiTietGiamTB = ChiTietGiamTB.builder()
                    .maPhieuGiam(giamTB.getMaPhieuGiam())
                    .maKP(chiTietGiamTBRequest.getMaKP())
                    .maTB(chiTietGiamTBRequest.getMaTB())
                    .slMat(0)
                    .slHong(chiTietGiamTBRequest.getHong())
                    .slConDungDuoc(chiTietGiamTBRequest.getConDungDuoc())
                    .build();
            giamTB.getChiTietGiamTBs().add(chiTietGiamTB);
            chiTietGiamTBRepository.save(chiTietGiamTB);
            DSThietBi dsThietBi = dsThietBiRepository.findDSThietBiByMaTBAndMaKP(chiTietGiamTB.getMaTB(), chiTietGiamTB.getMaKP());
            dsThietBi.setHong(dsThietBi.getHong() - chiTietGiamTB.getSlHong());
            dsThietBi.setTrongKho(dsThietBi.getTrongKho() - chiTietGiamTBRequest.getTongGiam());
            dsThietBi.setSoLuong(dsThietBi.getSoLuong() - chiTietGiamTBRequest.getTongGiam());
            dsThietBiRepository.save(dsThietBi);
        }
        return giamTBMapper.toGiamTBResponse(giamTB);
    }

    public GiamTBResponse updateGiamTB(String id, UpdateGiamTBRequest request) {
        GiamTB giamTB = giamTBRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GiamTB not found"));
        giamTBMapper.updateGiamTB(giamTB, request);
        giamTBRepository.save(giamTB);
        return giamTBMapper.toGiamTBResponse(giamTB);
    }

    private String generateMaPhieuGiam() {
        Optional<GiamTB> lastGiaoVien = giamTBRepository.findTopByOrderByMaPhieuGiamDesc();
        if (lastGiaoVien.isPresent()) {
            String lastMaGV = lastGiaoVien.get().getMaPhieuGiam();
            int nextId = Integer.parseInt(lastMaGV.substring(2)) + 1;
            return String.format("PG%05d", nextId);
        } else {
            return "PG00001";
        }
    }

}
