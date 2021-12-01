package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.mapper.ProductMapper;
import com.epam.spring.homework4.myRepository.ProductRepository;
import com.epam.spring.homework4.service.ProductService;
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

@WebMvcTest(value = ProductController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @Spy
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    private final long ID = 1;

    @Test
    void getAllProduct() throws Exception {

        ProductDTO productDTO = ProductDTO
                .builder()
                .id(1)
                .build();

        ProductDTO productDTO2 = ProductDTO
                .builder()
                .id(2)
                .build();

        when(productService.getAllProducts()).thenReturn(Arrays.asList(productDTO, productDTO2));

        mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(productDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(productDTO2.getId()));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProduct() throws Exception {

        ProductDTO productDTO = ProductDTO
                .builder()
                .id(ID)
                .build();

        when(productService.getProduct(ID)).thenReturn(productDTO);

        mockMvc
                .perform(get("/product/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productDTO.getId()));
    }

    @Test
    void createProduct() {

        Product product= new Product();
        product.setId(ID);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDTO productDTO = productMapper.mapProductDTO(product);

        Assertions.assertEquals(product.getId(), productDTO.getId());
    }

    @Test
    void deleteProduct() throws Exception {

        doNothing().when(productService).deleteProduct(ID);

        mockMvc.perform(delete("/product/" + ID))
                .andExpect(status().isNoContent());

        verify(productService, times(1)).deleteProduct(ID);
    }
}