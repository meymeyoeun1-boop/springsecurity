package com.mentor.springsecurity1.category.service;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponse;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;

public interface CategoryService {

    CategoryResponseDetail create(CategoryRequest request);

    CategoryResponseDetail getById(Long id);

    CategoryResponseDetail update(Long id,CategoryRequest request);

    void delete(Long id);

    void active(Long id);

    void inactive(Long id);

    CategoryResponse getCategoryPublic(Long id);
}
