package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product getProduct(long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(long id, Product product);

    void deleteProduct(long id);
}
