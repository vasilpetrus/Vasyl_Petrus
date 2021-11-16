package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.myRepository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    private final List<Category> listCategory = new ArrayList<>();

    @Override
    public Category getCategory(long id) {
        return listCategory.stream()
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category is not found!"));
    }

    @Override
    public List<Category> getAllCategory() {
        return new ArrayList<>(listCategory);
    }

    @Override
    public Category createCategory(Category category) {
        listCategory.add(category);
        return category;
    }

    @Override
    public Category updateCategory(long id, Category category) {
        boolean isDeleted = listCategory.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listCategory.add(category);
        } else {
            throw new RuntimeException("Category is not found!");
        }
        return category;
    }

    @Override
    public void deleteBankCard(long id) {
        listCategory.removeIf(category -> category.getId() == id);
    }
}
