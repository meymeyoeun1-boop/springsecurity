package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;

import java.util.List;


public interface ProductService {

    List<ProductResponse> getAllProducts();

    ProductResponseDetail addProduct(ProductRequest request);

    ProductResponseDetail update(Long id,ProductRequest request);

    void delete(Long id);

    ProductResponseDetail getById(Long id);


}
