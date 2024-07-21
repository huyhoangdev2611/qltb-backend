package com.qltb.service;

import com.qltb.entity.DMThietBi;
import com.qltb.entity.DonViTinh;
import com.qltb.entity.GiaoVien;
import com.qltb.mapper.DonViTinhMapper;
import com.qltb.model.request.create.CreateDonViTinhRequest;
import com.qltb.model.response.DonViTinhResponse;
import com.qltb.repository.DonViTinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonViTinhService {
    @Autowired
    private DonViTinhRepository donViTinhRepository;
    @Autowired
    private DonViTinhMapper donViTinhMapper;

    public List<DonViTinhResponse> getAll() {
        return donViTinhRepository.findAll()
                .stream().map(donViTinhMapper::toDonViTinhResponse).toList();
    }

    public DonViTinhResponse create(CreateDonViTinhRequest request) {
        DonViTinh donViTinh = donViTinhMapper.toDonViTinh(request);
        donViTinh.setMaDVT(generateMaDVT());
        return donViTinhMapper.toDonViTinhResponse(donViTinhRepository.save(donViTinh));
    }

    private String generateMaDVT() {
        Optional<DonViTinh> lastDonViTinh = donViTinhRepository.findTopByOrderByMaDVTDesc();
        if (lastDonViTinh.isPresent()) {
            String lastMaDVT = lastDonViTinh.get().getMaDVT();
            int nextId = Integer.parseInt(lastMaDVT.substring(3)) + 1;
            return String.format("DVT%05d", nextId);
        } else {
            return "DVT00001";
        }
    }

    public DonViTinhResponse getById(String maDVT) {
        DonViTinh donViTinh = donViTinhRepository.findById(maDVT)
                .orElseThrow(() -> new RuntimeException("Đơn vị tính không được tìm thấy"));
        List<DMThietBi> list = donViTinh.getDmThietBis();
        System.out.println(list);
        return donViTinhMapper.toDonViTinhResponse(donViTinh);
    }
}
