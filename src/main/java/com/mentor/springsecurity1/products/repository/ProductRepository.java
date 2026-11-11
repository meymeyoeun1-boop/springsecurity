package com.mentor.springsecurity1.products.repository;

import com.mentor.springsecurity1.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Long id(Long id);
}
