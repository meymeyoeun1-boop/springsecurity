package com.mentor.springsecurity1.service;

import com.mentor.springsecurity1.entity.User;
import com.mentor.springsecurity1.repository.RefreshTokenRepository;
import com.mentor.springsecurity1.repository.UserRepository;
import com.mentor.springsecurity1.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + email));
        CustomUserDetails details = new CustomUserDetails();
        details.setUser(user);
        return details;
    }
}
