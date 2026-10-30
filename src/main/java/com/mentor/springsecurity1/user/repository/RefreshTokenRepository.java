package com.mentor.springsecurity1.user.repository;

import com.mentor.springsecurity1.user.entity.RefreshToken;
import com.mentor.springsecurity1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
}
