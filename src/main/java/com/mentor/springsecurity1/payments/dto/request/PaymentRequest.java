package com.mentor.springsecurity1.payments.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    @NotNull
    private BigDecimal amount;

    private String method;

    private String status;

    private Long order_id;
}
