package com.mentor.springsecurity1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class LoginRequest {
    @NotBlank
    private  String username;

    @NotBlank
    private  String password;
}
