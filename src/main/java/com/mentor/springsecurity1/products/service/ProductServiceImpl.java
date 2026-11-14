package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.Share.PageResponse;
import com.mentor.springsecurity1.category.repository.CategoryRepository;
import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.request.ProductUpdateRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.entity.Product;
import com.mentor.springsecurity1.products.entity.ProductStatus;
import com.mentor.springsecurity1.products.mapper.ProductMapper;
import com.mentor.springsecurity1.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;



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
        Product data = productRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found: " + id));

        return productMapper.toProductResponseDetail(data);
    }

    @Override
    public ProductResponseDetail create(ProductRequest request, String sku, String name) {
        Product newProduct = productMapper.toEntity(request);


        if(productRepository.existsBySku(sku)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Sku is already exits");
        }
        if(productRepository.existsByNameIgnoreCase(newProduct.getName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "product name already exits");
        }
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toProductResponseDetail(savedProduct);
    }

    @Override
    public ProductResponseDetail update(ProductUpdateRequest request, Long id) {
        Product oldData = productRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "product not found"));

        if(request.sku() != null){
            if(productRepository.existsBySkuAndIdNotAndDeletedAtIsNull(request.sku(),id)){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "product sku already exits");
            }
            oldData.setSku(request.sku());
        }
        if(request.name() != null) oldData.setName(request.name());
        if (request.price()!=null) oldData.setPrice(request.price());
        if (request.stock()!=null) oldData.setStock(request.stock());
        if (request.status()!=null) oldData.setStatus(ProductStatus.valueOf(request.status()));
        return productMapper.toProductResponseDetail(productRepository.save(oldData));
    }


    @Override
    public ProductResponseDetail create(ProductRequest request, String sku, String name, String description) {
        return null;
    }

    @Override
    @Transactional
    public PageResponse<ProductResponseDetail> list(Pageable pageable) {
        Page<Product> productPage = productRepository.findAllByDeletedAtIsNull((org.springframework.data.domain.Pageable) pageable);
        return PageResponse.of(productPage,productMapper::toProductResponseDetail);
    }

    @Override
    public ProductResponseDetail addProduct(ProductRequest request) {
        return null;
    }


}
