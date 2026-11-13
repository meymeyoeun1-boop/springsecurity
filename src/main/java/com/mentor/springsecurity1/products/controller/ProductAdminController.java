package com.mentor.springsecurity1.products.controller;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/product")
public class ProductAdminController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDetail> addProduct(@Valid @RequestBody ProductRequest request){
        ProductResponseDetail response = productService.addProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDetail> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request){
        ProductResponseDetail updatedProduct = productService.update(id, request);
        return ResponseEntity.ok(updatedProduct);
    }


}