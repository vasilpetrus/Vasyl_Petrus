package com.epam.spring.homework4.dao;

import com.epam.spring.homework4.dto.CategoryDTO;

import java.util.List;

public interface CategoryDAO {

    CategoryDTO getCategory(long id);

    List<CategoryDTO> getAllCategory();

    CategoryDTO createCategory(CategoryDTO categoryDto);

    CategoryDTO updateCategory(long id, CategoryDTO categoryDTO);

    void deleteCategory(long id);
}
