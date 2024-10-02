package com.qltb.service;

import com.qltb.entity.GiaoVien;
import com.qltb.entity.TheoDoiHongMat;
import com.qltb.entity.ThietBi;
import com.qltb.mapper.TheoDoiHongMatMapper;
import com.qltb.model.request.create.TheoDoiHongMatCreateRequest;
import com.qltb.model.request.update.TheoDoiHongMatUpdateRequest;
import com.qltb.model.response.TheoDoiHongMatResponse;
import com.qltb.repository.TheoDoiHongMatRepository;
import com.qltb.repository.ThietBiRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheoDoiHongMatService {
    TheoDoiHongMatRepository theoDoiHongMatRepository;
    ThietBiRepository thietBiRepository;
    TheoDoiHongMatMapper theoDoiHongMatMapper;

    public TheoDoiHongMatResponse create(TheoDoiHongMatCreateRequest request) {
        TheoDoiHongMat theoDoiHongMat = theoDoiHongMatMapper.toTheoDoiHongMat(request);
        theoDoiHongMat.setMaPhieuBao(generateMaPhieuBao());
        ThietBi thietBi = thietBiRepository.findById(request.getMaCaBietTB()).orElseThrow(null);
        if (request.isHong()) {
            thietBi.setTinhTrang("Hỏng");
        }
        if (request.isMat()) {
            thietBi.setTrangThai("Đã mất");
//            thietBi.setTinhTrang("Mất");
//            thietBi.setDangHoatDong(false);
        }
        thietBiRepository.save(thietBi);
        return theoDoiHongMatMapper.toTheoDoiHongMatResponse(theoDoiHongMatRepository.save(theoDoiHongMat));
    }

    public Page<TheoDoiHongMatResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "maPhieuBao"));
        return theoDoiHongMatRepository.findAll(pageable).map(theoDoiHongMatMapper::toTheoDoiHongMatResponse);
    }

    private String generateMaPhieuBao() {
        Optional<TheoDoiHongMat> last = theoDoiHongMatRepository.findTopByOrderByMaPhieuBaoDesc();
        if (last.isPresent()) {
            String lastMaPhieuBao = last.get().getMaPhieuBao();
            int nextId = Integer.parseInt(lastMaPhieuBao.substring(3)) + 1;
            return String.format("PHM%05d", nextId);
        } else {
            return "PHM00001";
        }
    }

    public void delete(String maPhieuHongMat) {
        theoDoiHongMatRepository.deleteById(maPhieuHongMat);
    }

    public void update(String maPhieuBao, TheoDoiHongMatUpdateRequest request) {
        TheoDoiHongMat theoDoiHongMat = theoDoiHongMatRepository.findById(maPhieuBao).orElseThrow(null);
        theoDoiHongMatMapper.updateTheoDoiHongMat(theoDoiHongMat, request);
        theoDoiHongMatRepository.save(theoDoiHongMat);
    }
}
