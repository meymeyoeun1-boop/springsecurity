package com.mentor.springsecurity1.products.service;

import com.mentor.springsecurity1.Share.PageResponse;
import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.request.ProductUpdateRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;



public interface ProductService {

 ProductResponseDetail create(ProductRequest request, String sku, String name, String description);

 PageResponse<ProductResponseDetail> list(Pageable pageable);

    ProductResponseDetail addProduct(ProductRequest request);

    ProductResponseDetail update(Long id,ProductRequest request);

    void delete(Long id);

    ProductResponseDetail getById(Long id);

    ProductResponseDetail create(ProductRequest request,String sku,String name);

    ProductResponseDetail update(ProductUpdateRequest request,Long id);


}
