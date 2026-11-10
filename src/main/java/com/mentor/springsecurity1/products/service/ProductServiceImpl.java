package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.mapper.ProductMapper;
import com.mentor.springsecurity1.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDetail create(ProductRequest request) {
        return null;
    }

    @Override
    public ProductResponseDetail update(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductResponseDetail getById(Long id) {
        return null;
    }



    @Transactional
    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }






}
