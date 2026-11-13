package com.mentor.springsecurity1.products.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotNull(message = "name is request")
    @Size(min = 2, max = 2500)
    String name;

    @NotNull @DecimalMax("0.00") @Digits(integer = 10,fraction = 2)
    BigDecimal price;

    @NotNull @PositiveOrZero Integer stock;

    @NotNull @Size(max = 50)
    String sku;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    String status;

    @NotNull Long categoryId;
}


