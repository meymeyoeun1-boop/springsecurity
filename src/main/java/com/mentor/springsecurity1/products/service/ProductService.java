package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;

public interface ProductService {

    ProductResponseDetail create(ProductRequest request);

    ProductResponseDetail update(Long id,ProductRequest request);

    ProductResponseDetail delete(Long id);

    ProductResponseDetail getById(Long id);
}
