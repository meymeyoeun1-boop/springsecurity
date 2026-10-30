package com.mentor.springsecurity1.orders.entity;

import com.mentor.springsecurity1.order_items.entity.Order_Item;
import com.mentor.springsecurity1.payments.entity.Payment;
import com.mentor.springsecurity1.Share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import com.mentor.springsecurity1.user.entity.User;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends BaseEntity {

    @Column(nullable = false)
    private String status; // ឧទាហរណ៍: PENDING, PAID, CANCELLED

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 👈 ឥឡូវវានឹងស្គាល់ជា Entity ត្រឹមត្រូវ

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order_Item> order_items;
}