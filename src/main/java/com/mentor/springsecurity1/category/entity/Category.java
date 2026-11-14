package com.mentor.springsecurity1.category.entity;

import com.mentor.springsecurity1.Share.BaseEntity;
import com.mentor.springsecurity1.products.entity.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE category SET delete_at = name() WHERE ID = ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categories")
@Builder
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private CategoryStatus categoryStatus = CategoryStatus.INACTIVE;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;


    public void setId(Long categoryId) {
    }
}
