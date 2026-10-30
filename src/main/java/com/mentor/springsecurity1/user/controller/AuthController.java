package com.mentor.springsecurity1.user.controller;


import com.mentor.springsecurity1.user.dto.request.LoginRequest;
import com.mentor.springsecurity1.user.dto.request.RefreshTokenRequest;
import com.mentor.springsecurity1.user.dto.request.RegisterRequest;
import com.mentor.springsecurity1.user.dto.response.AuthResponse;
import com.mentor.springsecurity1.user.service.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok(Map.of("massage","User registered successfully"));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh (@Valid @RequestBody RefreshTokenRequest request){
        return ResponseEntity.ok(authService.refresh(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authService.logout(auth.getName());
        return ResponseEntity.ok(Map.of("massage","logged out successfully"));
    }

}
