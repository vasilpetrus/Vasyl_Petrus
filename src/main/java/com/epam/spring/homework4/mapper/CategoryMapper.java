package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    List<CategoryDTO> mapCategoryDto(List<Category>orders);

    CategoryDTO mapCategoryDTO(Category category);

    Category mapCategory(CategoryDTO categoryDTO);
}
