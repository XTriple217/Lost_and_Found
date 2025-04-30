package com.lostandfound.controller;

import com.lostandfound.entity.User;
import com.lostandfound.payload.AuthRequest;
import com.lostandfound.payload.AuthResponse;
import com.lostandfound.payload.JwtUtil;
import com.lostandfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody User user) {
        userService.register(user);
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(201, token);
    }

    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody AuthRequest request) {
        User user = userService.authenticate(request.getEmail(), request.getPassword());
        if (user == null || user.isBanned()) {
            return new AuthResponse(403, "Unauthorized or banned.");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(200, token);
    }
}
