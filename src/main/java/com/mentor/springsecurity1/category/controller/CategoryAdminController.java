package com.mentor.springsecurity1.category.controller;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;
import com.mentor.springsecurity1.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/categories")
@RequiredArgsConstructor
public class CategoryAdminController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CategoryResponseDetail create(@Valid@RequestBody CategoryRequest categoryRequest){
      return categoryService.create(categoryRequest);
    }

    @GetMapping("/{id}")
    public CategoryResponseDetail getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDetail update(@PathVariable Long id, @Valid  @RequestBody CategoryRequest categoryRequest){
        return categoryService.update(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDetail delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}

