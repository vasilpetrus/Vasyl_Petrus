package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product")
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
