package com.finance.dashboard.controller;

import com.finance.dashboard.dto.*;
import com.finance.dashboard.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    // 🔹 REGISTER API
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    // 🔹 LOGIN API
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return service.login(request);
    }
}
