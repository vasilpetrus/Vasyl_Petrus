package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.dto.CategoryDTO.CategoryDTOBuilder;
import com.epam.spring.homework4.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-30T18:01:46+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryDTO> mapCategoryDto(List<Category> orders) {
        if ( orders == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( orders.size() );
        for ( Category category : orders ) {
            list.add( mapCategoryDTO( category ) );
        }

        return list;
    }

    @Override
    public CategoryDTO mapCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.id( category.getId() );
        categoryDTO.category( category.getCategory() );

        return categoryDTO.build();
    }

    @Override
    public Category mapCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setCategory( categoryDTO.getCategory() );

        return category;
    }
}
