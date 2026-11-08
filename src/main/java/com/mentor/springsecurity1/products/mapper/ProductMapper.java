package com.mentor.springsecurity1.products.mapper;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.entity.Product;

public interface ProductMapper {

    Product toEntity (ProductRequest productRequest);

    ProductResponseDetail toProductResponseDetail(Product product);

    ProductResponse toProductResponse(Product product);
}
