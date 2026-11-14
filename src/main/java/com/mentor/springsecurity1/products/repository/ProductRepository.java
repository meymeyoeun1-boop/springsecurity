package com.mentor.springsecurity1.products.repository;

import com.mentor.springsecurity1.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByDeletedAtIsNull(Pageable pageable);

    Optional<Product> findByIdAndDeletedAtIsNull(Long id);

   boolean existsBySku(String sku);

    boolean existsByNameIgnoreCase(String name);


    boolean existsBySkuAndIdNotAndDeletedAtIsNull(String sku, Long id);

}
