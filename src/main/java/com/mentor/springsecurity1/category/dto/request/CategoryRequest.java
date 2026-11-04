package com.mentor.springsecurity1.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CategoryRequest(@NotBlank String name, @NotBlank@Pattern(regexp = "^(ACTIVE|INACTIVE)$")
                              String status) {



}
