package com.mentor.springsecurity1.products.repository;

import com.mentor.springsecurity1.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByDeletedAtIsNull(Pageable pageable);
}
