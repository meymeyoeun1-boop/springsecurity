package com.mentor.springsecurity1.category.controller;

import com.mentor.springsecurity1.category.entity.Category;
import com.mentor.springsecurity1.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public ResponseEntity<Category> addCategory(Category category){
        return ResponseEntity.ok(categoryRepository.save(category));
    }
}
