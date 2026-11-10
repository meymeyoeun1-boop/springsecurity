package com.mentor.springsecurity1.category.controller;

import com.mentor.springsecurity1.category.dto.response.CategoryResponse;
import com.mentor.springsecurity1.category.entity.Category;
import com.mentor.springsecurity1.category.repository.CategoryRepository;
import com.mentor.springsecurity1.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService Service;

    @GetMapping("/{id}")
    public CategoryResponse getCategoryPublic(@PathVariable Long id) {
        return Service.getCategoryPublic(id);
    }

}
