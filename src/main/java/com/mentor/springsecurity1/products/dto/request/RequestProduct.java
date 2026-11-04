package com.mentor.springsecurity1.products.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestProduct {

    @NotNull(message = "name is request")
    @Size(min = 2, max = 2500)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    private Integer stock;

    private Boolean active;

    private String sku;

    private Long categoryId;
}


