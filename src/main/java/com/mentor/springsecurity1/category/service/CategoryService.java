package com.mentor.springsecurity1.category.service;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;

public interface CategoryService {

    CategoryResponseDetail create(CategoryRequest request);

    CategoryResponseDetail getById(Long id);

    CategoryResponseDetail update(Long id,CategoryRequest request);

    CategoryResponseDetail delete(Long id);
}
