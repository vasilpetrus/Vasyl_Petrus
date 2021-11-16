package com.epam.spring.homework4.dao;

import com.epam.spring.homework4.dto.ProductDTO;

import java.util.List;

public interface ProductDAO {

    ProductDTO getProduct(long id);

    List<ProductDTO> getAllProducts();

    ProductDTO createProduct(ProductDTO productDto);

    ProductDTO updateProduct(long id, ProductDTO productDto);

    void deleteProduct(long id);
}
