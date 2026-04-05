package com.finance.dashboard.service;

import com.finance.dashboard.dto.*;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;
import com.finance.dashboard.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    // 🔹 REGISTER
    public String register(RegisterRequest request) {

        // check if email exists
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // 🔐 encrypt password
        user.setPassword(encoder.encode(request.getPassword()));

        // set role (default = VIEWER if null)
        user.setRole(request.getRole() != null ? request.getRole() : 
                     com.finance.dashboard.entity.Role.ROLE_VIEWER);

        user.setActive(true);

        userRepo.save(user);

        return "User registered successfully";
    }

    // 🔹 LOGIN
    public AuthResponse login(AuthRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token); // ✅ MUST RETURN
    }
    
}