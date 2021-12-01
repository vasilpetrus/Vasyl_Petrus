package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.mapper.ProductMapper;
import com.epam.spring.homework4.myRepository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Spy
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    private final long ID = 1;

    @Test
    void getProduct() {

        Product product = new Product();
        product.setId(ID);
        when(productRepository.findById(ID)).thenReturn(product);

        ProductDTO productDTO = productService.getProduct(ID);

        assertEquals(product.getId(), productDTO.getId());
    }

    @Test
    void getAllProducts() {

        Product product1 = new Product();
        Product product2 = new Product();
        product1.setId(ID);
        product1.setId(ID);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<ProductDTO> resultList = productService.getAllProducts();

        assertEquals(2, resultList.size());
    }

    @Test
    void createProduct() {

        Product product = new Product();
        product.setId(ID);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDTO productDTO = productService.createProduct(productMapper.mapProductDTO(product));

        assertEquals(productDTO.getId(), product.getId());
    }

    @Test
    void deleteProduct() {

        doNothing().when(productRepository).deleteById(ID);

        productService.deleteProduct(ID);

        verify(productRepository, times(1)).deleteById(ID);
    }
}