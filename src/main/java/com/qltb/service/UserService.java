package com.qltb.service;

import com.qltb.entity.User;
import com.qltb.model.response.GiaoVienResponse;
import com.qltb.model.response.UserResponse;
import com.qltb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByMaGV(String maGV) {
        return userRepository.existsByMaGV(maGV);
    }

    public UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setMaGV(user.getMaGV());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        if (user.getGiaoVien() != null) {
            GiaoVienResponse giaoVienResponse = new GiaoVienResponse();
            giaoVienResponse.setMaGV(user.getGiaoVien().getMaGV());
            giaoVienResponse.setTenGV(user.getGiaoVien().getTenGV());
            giaoVienResponse.setGioiTinh(user.getGiaoVien().getGioiTinh());
            giaoVienResponse.setNgaySinh(user.getGiaoVien().getNgaySinh());
            giaoVienResponse.setSoDienThoai(user.getGiaoVien().getSoDienThoai());
            giaoVienResponse.setDiaChi(user.getGiaoVien().getDiaChi());
            giaoVienResponse.setMaToCM(user.getGiaoVien().getMaToCM());
            userResponse.setGiaoVien(giaoVienResponse);
        }

        return userResponse;
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

}
