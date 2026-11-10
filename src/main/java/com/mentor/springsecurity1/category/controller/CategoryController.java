package com.mentor.springsecurity1.category.controller;

import com.mentor.springsecurity1.category.dto.response.CategoryResponse;
import com.mentor.springsecurity1.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService Service;

    @GetMapping("/{id}")
    public CategoryResponse getCategoryPublic(@PathVariable Long id) {
        return Service.getCategoryPublic(id);
    }


    @PatchMapping("/{id}/active")
    public ResponseEntity<Void> active(@PathVariable Long id) {
        Service.active(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}/inactive")
    public ResponseEntity<Void> inactive(@PathVariable Long id) {
        Service.inactive(id);
        return ResponseEntity.ok().build();
    }

}
