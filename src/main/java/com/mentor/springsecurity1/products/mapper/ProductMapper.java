package com.mentor.springsecurity1.products.mapper;

import com.mentor.springsecurity1.products.dto.request.ProductRequest;
import com.mentor.springsecurity1.products.dto.response.ProductResponseDetail;
import com.mentor.springsecurity1.products.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId",source = "category.id")
    @Mapping(target = "categoryName",source = "category.name")
    ProductResponseDetail toProductResponseDetail(Product product);
    @Mapping(target = "category.id",source = "categoryId")
    Product toEntity(ProductRequest request);
}
