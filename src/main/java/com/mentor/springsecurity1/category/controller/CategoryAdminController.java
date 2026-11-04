package com.mentor.springsecurity1.category.controller;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;
import com.mentor.springsecurity1.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/categories")
@RequiredArgsConstructor
public class CategoryAdminController {

    private final CategoryService categoryService;

    @ResponseStatus
    @PostMapping()
    public CategoryResponseDetail create(@Valid@RequestBody CategoryRequest categoryRequest){
      return categoryService.create(categoryRequest);
    }
}

