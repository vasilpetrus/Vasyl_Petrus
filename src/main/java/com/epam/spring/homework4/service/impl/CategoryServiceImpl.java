package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.service.CategoryService;
import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.mapper.CategoryMapper;
import com.epam.spring.homework4.myRepository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO getCategory(long id) {
        log.info("get category by id {}", id);
        Category category = categoryRepository.getCategory(id);
        return CategoryMapper.INSTANCE.mapCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        log.info("get all categories");
        return CategoryMapper.INSTANCE.mapCategoryDto(categoryRepository.getAllCategory());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
        log.info("create category with id {}", categoryDto.getId());
        Category category = CategoryMapper.INSTANCE.mapCategory(categoryDto);
        category = categoryRepository.createCategory(category);
        return CategoryMapper.INSTANCE.mapCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(long id, CategoryDTO categoryDTO) {
        log.info("update category with id {}", id);
        Category category = CategoryMapper.INSTANCE.mapCategory(categoryDTO);
        category = categoryRepository.updateCategory(id, category);
        return CategoryMapper.INSTANCE.mapCategoryDTO(category);
    }

    @Override
    public void deleteCategory(long id) {
        log.info("delete category by id {}", id);
        categoryRepository.deleteBankCard(id);
    }
}