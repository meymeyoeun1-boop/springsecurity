package com.mentor.springsecurity1.products.repository;

import com.mentor.springsecurity1.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByDeletedAtIsNull(Long pageable);

    Optional<Product> findByIdAndDeletedAtIsNull(Long id);

    Optional<Object> findAllByDeletedAtIsNull(LocalDateTime deletedAt);
}
