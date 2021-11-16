package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.myRepository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> listProduct = new ArrayList<>();

    @Override
    public Product getProduct(long id) {
        return listProduct.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product is not found!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(listProduct);
    }

    @Override
    public Product createProduct(Product product) {
        listProduct.add(product);
        return product;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        boolean isDeleted = listProduct.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listProduct.add(product);
        } else {
            throw new RuntimeException("Product is not found!");
        }
        return product;
    }

    @Override
    public void deleteProduct(long id) {
        listProduct.removeIf(product -> product.getId() == id);
    }
}
