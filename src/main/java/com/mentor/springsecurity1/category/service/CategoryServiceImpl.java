package com.mentor.springsecurity1.category.service;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;
import com.mentor.springsecurity1.category.entity.Category;
import com.mentor.springsecurity1.category.mapper.CategoryMapper;
import com.mentor.springsecurity1.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDetail create(CategoryRequest request) {
        String name = request.name().toLowerCase().trim();

        if (categoryRepository.existsByName(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category with name " + name + " already exists");
        }
        Category entity = categoryMapper.toEntity(request);
        categoryRepository.save(entity);
        return categoryMapper.toResponseDetail(entity);
    }

    @Override
    public CategoryResponseDetail getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return categoryMapper.toResponseDetail(category);
    }
    @Override
    public CategoryResponseDetail update(Long id,CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        category.setName(request.name());
        Category updated = categoryRepository.save(category);
        return categoryMapper.toResponseDetail(updated);
    }

    @Override
    public CategoryResponseDetail delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " does not exist."));
        categoryRepository.delete(category);
        return categoryMapper.toResponseDetail(category);
    }

}
