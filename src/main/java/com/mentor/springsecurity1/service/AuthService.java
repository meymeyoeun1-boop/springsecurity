package com.mentor.springsecurity1.service;


import com.mentor.springsecurity1.dto.request.LoginRequest;
import com.mentor.springsecurity1.dto.request.RegisterRequest;
import com.mentor.springsecurity1.entity.Role;
import com.mentor.springsecurity1.entity.User;
import com.mentor.springsecurity1.repository.RoleRepository;
import com.mentor.springsecurity1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isVerified(true) // True for testing; false in real email-verification flow
                .isBlocked(false)
                .isDeleted(false)
                .roles(Set.of(userRole))
                .build();

        userRepository.save(user);
    }
    public void login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
