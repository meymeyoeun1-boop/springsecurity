package com.mentor.springsecurity1.order_items.entity;


import com.mentor.springsecurity1.Share.BaseEntity;
import com.mentor.springsecurity1.orders.entity.Order;
import com.mentor.springsecurity1.products.entity.Product;
import jakarta.persistence.*;

import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order_Item extends BaseEntity {

    @Column(name ="product_name", nullable = false)
    private String product_name;

    @Column(name= "unit_price", nullable = false)
    private BigDecimal unit_price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
