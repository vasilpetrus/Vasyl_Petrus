package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long id);

    List<Category> findAll();

    Category save(Category category);

    void deleteById(long id);
}
