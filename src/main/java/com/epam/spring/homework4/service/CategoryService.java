package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO getCategory(long id);

    List<CategoryDTO> getAllCategory();

    CategoryDTO createCategory(CategoryDTO categoryDto);

    CategoryDTO updateCategory(long id, CategoryDTO categoryDTO);

    void deleteCategory(long id);
}