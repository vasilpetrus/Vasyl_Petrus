package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getProduct(long id);

    List<ProductDTO> getAllProducts();

    ProductDTO createProduct(ProductDTO productDto);

    void deleteProduct(long id);
}
