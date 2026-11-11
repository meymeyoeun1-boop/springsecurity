package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.category.entity.Category;
import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.entity.Product;
import com.mentor.springsecurity1.products.mapper.ProductMapper;
import com.mentor.springsecurity1.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDetail addProduct(ProductRequest request) {
        Product newProduct = productMapper.toEntity(request);
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toProductResponseDetail(savedProduct);
    }

    @Override
    public ProductResponseDetail update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        product.setName(request.getName());
        Product updated = productRepository.save(product);
        return productMapper.toProductResponseDetail(updated);
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
