package com.mentor.springsecurity1.products.controller;

import com.mentor.springsecurity1.Share.PageResponse;
import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.request.ProductUpdateRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDetail create(@RequestBody ProductRequest request,String sku,String name){
        return productService.create(request, sku ,name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDetail getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDetail update(@RequestBody @Valid Long id, ProductUpdateRequest request){
        return productService.update(request, id);
    }

    
}
