package com.mentor.springsecurity1.products.controller;

import com.mentor.springsecurity1.products.dto.response.ProductResponse;
import com.mentor.springsecurity1.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/product")
public class ProductAdminController {

    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>>  getAllProducts(){
        List<ProductResponse> list = productService.getAllProducts();
        return ResponseEntity.ok(list);

    }
}
