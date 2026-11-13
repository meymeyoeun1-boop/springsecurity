package com.mentor.springsecurity1.products.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

public record ProductResponseDetail(Long id,
                                    String name,
                                    String sku,
                                    String stockKeepingUnit,
                                    BigDecimal price,
                                    @JsonProperty("categoryIds")Long categoryId,
                                    String categoryName,
                                    Integer stock,
                                    LocalDateTime createdAt) {
}
