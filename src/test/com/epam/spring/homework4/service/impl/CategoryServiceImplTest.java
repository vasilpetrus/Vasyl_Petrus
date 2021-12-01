package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.mapper.CategoryMapper;
import com.epam.spring.homework4.myRepository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    private final long ID = 1;

    @Test
    void getCategory() {

        Category category = new Category();
        category.setId(ID);
        when(categoryRepository.findById(ID)).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategory(ID);

        assertEquals(category.getId(), categoryDTO.getId());
    }

    @Test
    void getAllCategory() {

        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(ID);
        category2.setId(ID);

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        List<CategoryDTO> resultList = categoryService.getAllCategory();

        assertEquals(2, resultList.size());
    }

    @Test
    void createCategory() {

        Category category = new Category();
        category.setId(ID);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.createCategory(categoryMapper.mapCategoryDTO(category));

        assertEquals(categoryDTO.getId(), category.getId());
    }

    @Test
    void deleteCategory() {

        doNothing().when(categoryRepository).deleteById(ID);

        categoryService.deleteCategory(ID);

        verify(categoryRepository, times(1)).deleteById(ID);
    }
}