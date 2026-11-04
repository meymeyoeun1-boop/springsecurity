package com.mentor.springsecurity1.category.mapper;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponse;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;
import com.mentor.springsecurity1.category.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequest request);

    CategoryResponseDetail toResponseDetail(Category category);

    CategoryResponse toResponse(Category category);


}
