package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.ProductDAO;
import com.epam.spring.homework4.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductDAO productDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product")
    public List<ProductDTO> getAllProduct() {
        return productDAO.getAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productDAO.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productDAO.createProduct(productDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/product/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return productDAO.updateProduct(id, productDTO);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productDAO.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
