package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/category")
    public List<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/category/{id}")
    public CategoryDTO getCategory(@PathVariable long id) {
        return categoryService.getCategory(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/category")
    public CategoryDTO createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/category/{id}")
    public CategoryDTO updateCategory(@PathVariable long id, @RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.updateCategory(id, categoryDTO);
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
