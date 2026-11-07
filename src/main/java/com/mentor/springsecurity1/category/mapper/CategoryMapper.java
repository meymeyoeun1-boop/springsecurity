package com.mentor.springsecurity1.category.mapper;

import com.mentor.springsecurity1.category.dto.request.CategoryRequest;
import com.mentor.springsecurity1.category.dto.response.CategoryResponse;
import com.mentor.springsecurity1.category.dto.response.CategoryResponseDetail;
import com.mentor.springsecurity1.category.entity.Category;
import com.mentor.springsecurity1.category.entity.CategoryStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryStatus", source = "status")
    Category toEntity(CategoryRequest request);

    @Mapping(target = "status", source = "categoryStatus")
    CategoryResponseDetail toResponseDetail(Category category);

    CategoryResponse toResponse(Category category);

    default CategoryStatus mapToEnum(String value) {
        if (value == null) {
            return null;
        }
        return CategoryStatus.valueOf(value);
    }

    default String mapToString(CategoryStatus status) {
        if (status == null) {
            return null;
        }
        return status.name();
    }


}
