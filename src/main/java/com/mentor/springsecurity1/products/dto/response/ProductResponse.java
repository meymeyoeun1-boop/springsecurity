package com.mentor.springsecurity1.products.dto.response;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime deleted_at;
    private Long category_id;
}
