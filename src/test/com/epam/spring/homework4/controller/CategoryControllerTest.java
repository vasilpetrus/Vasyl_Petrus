package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.mapper.CategoryMapper;
import com.epam.spring.homework4.myRepository.CategoryRepository;
import com.epam.spring.homework4.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(value = CategoryController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class CategoryControllerTest {

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    private final long ID = 1;

    @Test
    void getAllCategory() throws Exception {

        CategoryDTO categoryDTO = CategoryDTO
                .builder()
                .id(1)
                .build();

        CategoryDTO categoryDTO2 = CategoryDTO
                .builder()
                .id(2)
                .build();

        when(categoryService.getAllCategory()).thenReturn(Arrays.asList(categoryDTO, categoryDTO2));

        mockMvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(categoryDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(categoryDTO2.getId()));

        verify(categoryService, times(1)).getAllCategory();
    }

    @Test
    void getCategory() throws Exception {

        CategoryDTO categoryDTO = CategoryDTO
                .builder()
                .id(ID)
                .build();

        when(categoryService.getCategory(ID)).thenReturn(categoryDTO);

        mockMvc
                .perform(get("/category/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(categoryDTO.getId()));
    }

    @Test
    void createCategory() {

        Category category = new Category();
        category.setId(ID);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDTO categoryDTO = categoryMapper.mapCategoryDTO(category);

        Assertions.assertEquals(category.getId(), categoryDTO.getId());
    }

    @Test
    void deleteCategory() throws Exception {

        doNothing().when(categoryService).deleteCategory(ID);

        mockMvc.perform(delete("/category/" + ID))
                .andExpect(status().isNoContent());

        verify(categoryService, times(1)).deleteCategory(ID);
    }
}