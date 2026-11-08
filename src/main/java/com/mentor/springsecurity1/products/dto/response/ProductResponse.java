package com.mentor.springsecurity1.products.dto.response;

import java.math.BigDecimal;

public record ProductResponse(Long id,
                              String name,
                              String sku,
                              BigDecimal price,
                              Integer stock,
                              Boolean active) {
}
