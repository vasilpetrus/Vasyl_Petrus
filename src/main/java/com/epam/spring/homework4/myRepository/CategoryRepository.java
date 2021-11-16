package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Category;

import java.util.List;

public interface CategoryRepository {

    Category getCategory(long id);

    List<Category> getAllCategory();

    Category createCategory(Category category);

    Category updateCategory(long id, Category category);

    void deleteBankCard(long id);
}
