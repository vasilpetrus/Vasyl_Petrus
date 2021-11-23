package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.mapper.ProductMapper;
import com.epam.spring.homework4.myRepository.ProductRepository;
import com.epam.spring.homework4.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(long id) {
        log.info("get product by id {}", id);
        Product product = productRepository.findById(id);
        return ProductMapper.INSTANCE.mapProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("get all products");
        return ProductMapper.INSTANCE.mapProductDto(productRepository.findAll());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        log.info("create product with id {}", productDto.getId());
        Product product = ProductMapper.INSTANCE.mapProduct(productDto);
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.mapProductDTO(product);
    }

    @Override
    public void deleteProduct(long id) {
        log.info("delete product by id {}", id);
        productRepository.deleteById(id);
    }
}
