package com.qltb.controller;

import com.qltb.entity.User;
import com.qltb.model.response.UserResponse;
import com.qltb.service.UserService;
import com.qltb.util.JwtUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByEmail(loginRequest.getEmail());

            if (user == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            // Tạo JWT Token
            String token = jwtUtils.generateToken(user.getEmail());

            // Convert User to UserResponse
            UserResponse userResponse = userService.convertToUserResponse(user);

            // Return JSON response
            return ResponseEntity.ok(new LoginResponse("Login successful", token, "Bearer", userResponse));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User signUpRequest) {
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        if (userService.existsByMaGV(signUpRequest.getMaGV())) {
            return ResponseEntity.badRequest().body("Error: Ma GV is already in use!");
        }

        User user = userService.createUser(signUpRequest);
        UserResponse userResponse = userService.convertToUserResponse(user);

        // Tạo JWT Token
        String token = jwtUtils.generateToken(user.getEmail());

        // Return JSON response
        return ResponseEntity.status(201).body(new LoginResponse("User registered successfully", token, "Bearer", userResponse));
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam Long userId, @RequestBody ChangePasswordRequest changePasswordRequest) {
        try {

            User user = userService.findById(userId);

            if (user == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            // Kiểm tra xem mật khẩu hiện tại có đúng không
            if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
                return ResponseEntity.status(400).body("Current password is incorrect");
            }

            // Cập nhật mật khẩu mới
            user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
            userService.updateUser(user);

            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating password: " + e.getMessage());
        }
    }


    // Inner class for ChangePasswordRequest
    @Data
    public static class ChangePasswordRequest {
        private String currentPassword;
        private String newPassword;
    }

    // Inner class for LoginResponse
    @Data
    public static class LoginResponse {
        private String message;
        private String accessToken;
        private String tokenType;
        private UserResponse user;

        public LoginResponse(String message, String accessToken, String tokenType, UserResponse user) {
            this.message = message;
            this.accessToken = accessToken;
            this.tokenType = tokenType;
            this.user = user;
        }
    }
}
