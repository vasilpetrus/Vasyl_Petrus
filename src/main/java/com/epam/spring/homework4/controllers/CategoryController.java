package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.CategoryDAO;
import com.epam.spring.homework4.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDAO categoryDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/category")
    public List<CategoryDTO> getAllCategory() {
        return categoryDAO.getAllCategory();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/category/{id}")
    public CategoryDTO getCategory(@PathVariable long id) {
        return categoryDAO.getCategory(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryDAO.createCategory(categoryDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/category/{id}")
    public CategoryDTO updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        return categoryDAO.updateCategory(id, categoryDTO);
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        categoryDAO.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
