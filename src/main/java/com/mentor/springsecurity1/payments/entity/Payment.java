package com.mentor.springsecurity1.payments.entity;

import com.mentor.springsecurity1.Share.BaseEntity;
import com.mentor.springsecurity1.orders.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name= "payments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends BaseEntity {

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    private String method;

    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order")
    private Order order;


}
