package com.mentor.springsecurity1.user.service;

import com.mentor.springsecurity1.user.dto.request.LoginRequest;
import com.mentor.springsecurity1.user.dto.request.RefreshTokenRequest;
import com.mentor.springsecurity1.user.dto.request.RegisterRequest;
import com.mentor.springsecurity1.user.dto.response.AuthResponse;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    AuthResponse refresh(RefreshTokenRequest request);

    void logout(String email);
}
