package com.mentor.springsecurity1.controller;


import com.mentor.springsecurity1.dto.request.RegisterRequest;
import com.mentor.springsecurity1.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok(Map.of("massage","User registered successfully"));

    }
    public ResponseEntity<Map<String, String>> logout (HttpSession session){
        session.invalidate();
        return ResponseEntity.ok(Map.of("message","Logged out successfully"));
    }

}
