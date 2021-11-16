package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.CategoryDAO;
import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.myRepository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryDAOImpl implements CategoryDAO {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO getCategory(long id) {
        log.info("get category by id {}", id);
        Category category = categoryRepository.getCategory(id);
        return mapCategoryToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        log.info("get all categories");
        return categoryRepository.getAllCategory()
                .stream()
                .map(this::mapCategoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
        log.info("create category with id {}", categoryDto.getId());
        Category category = mapCategoryDTOToCategory(categoryDto);
        category = categoryRepository.createCategory(category);
        return mapCategoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(long id, CategoryDTO categoryDTO) {
        log.info("update category with id {}", id);
        Category category = mapCategoryDTOToCategory(categoryDTO);
        category = categoryRepository.updateCategory(id, category);
        return mapCategoryToCategoryDTO(category);
    }

    @Override
    public void deleteCategory(long id) {
        log.info("delete category by id {}", id);
        categoryRepository.deleteBankCard(id);
    }

    private CategoryDTO mapCategoryToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .category(category.getCategory())
                .build();
    }

    private Category mapCategoryDTOToCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .category(categoryDTO.getCategory())
                .build();
    }
}
