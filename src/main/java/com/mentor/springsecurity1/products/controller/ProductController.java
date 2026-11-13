package com.mentor.springsecurity1.products.controller;

import com.mentor.springsecurity1.Share.PageResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RequestMapping("api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public PageResponse<ProductResponseDetail> list(
            @PageableDefault(size = 10) Pageable pageable) {

       PageResponse<ProductResponseDetail> response = productService.list(pageable);
       return response;
    }
    
}
