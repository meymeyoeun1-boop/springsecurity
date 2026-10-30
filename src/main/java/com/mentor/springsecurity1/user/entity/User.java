package com.mentor.springsecurity1.user.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_account_no_expired",nullable = false)
    private Boolean isAccountNoExpired = true;

    @Column(name ="is_credentials_no_expired",nullable = false)
    private Boolean isCredentialsNoExpired = true;

    @Column(name ="is_verified",nullable = false)
    private Boolean isVerified = false;

    @Column(name ="is_account_non_locked",nullable = false)
    private Boolean isAccountMonLocked= true;

    @Column(name ="is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

}