package com.mentor.springsecurity1.user.service;

import com.mentor.springsecurity1.user.dto.request.LoginRequest;
import com.mentor.springsecurity1.user.dto.request.RefreshTokenRequest;
import com.mentor.springsecurity1.user.dto.request.RegisterRequest;

import com.mentor.springsecurity1.user.dto.response.AuthResponse;
import com.mentor.springsecurity1.user.entity.RefreshToken;
import com.mentor.springsecurity1.user.entity.Role;
import com.mentor.springsecurity1.user.entity.User;
import com.mentor.springsecurity1.user.repository.RefreshTokenRepository;
import com.mentor.springsecurity1.user.repository.RoleRepository;
import com.mentor.springsecurity1.user.repository.UserRepository;
import com.mentor.springsecurity1.user.security.CustomUserDetails;
import com.mentor.springsecurity1.user.security.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.jwt.refresh-expiration}")
    private long refreshExpiration;

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isVerified(true)
                .isAccountNonLocked(true)
                .isAccountNoExpired(true)
                .isCredentialsNonExpired(true)
                .isDeleted(false)
                .roles(Set.of(userRole))
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
        User user = details.getUser();

        String accessToken = jwtService.generateToken(details);
        String refreshToken = createRefreshToken(user).getToken();

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse refresh(RefreshTokenRequest request) {
        RefreshToken saved = refreshTokenRepository.findByToken(request.getRefreshToken())
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (saved.getExpiryDate().isBefore(Instant.now())) {
            refreshTokenRepository.delete(saved);
            throw new RuntimeException("Refresh token expired");
        }

        CustomUserDetails details = new CustomUserDetails();
        details.setUser(saved.getUser());

        return new AuthResponse(jwtService.generateToken(details), saved.getToken());
    }

    @Transactional
    public void logout(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        refreshTokenRepository.deleteByUser(user);
    }

    // ទទួលយក User object ជា Parameter
    private RefreshToken createRefreshToken(User user) {
        return refreshTokenRepository.save(RefreshToken.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(refreshExpiration))
                .build());
    }
}