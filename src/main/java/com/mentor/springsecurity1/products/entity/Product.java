package com.mentor.springsecurity1.products.entity;

import com.mentor.springsecurity1.Share.BaseEntity;
import com.mentor.springsecurity1.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    private Integer stock;

    private Boolean active;

    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
