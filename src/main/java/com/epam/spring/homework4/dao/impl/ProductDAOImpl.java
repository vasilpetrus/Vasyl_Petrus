package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.ProductDAO;
import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.myRepository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(long id) {
        log.info("get product by id {}", id);
        Product product = productRepository.getProduct(id);
        return mapProductToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("get all products");
        return productRepository.getAllProducts()
                .stream()
                .map(this::mapProductToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        log.info("create product with id {}", productDto.getId());
        Product product = mapProductDTOToProduct(productDto);
        product = productRepository.createProduct(product);
        return mapProductToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(long id, ProductDTO productDto) {
        log.info("update product with id {}", id);
        Product product = mapProductDTOToProduct(productDto);
        product = productRepository.updateProduct(id, product);
        return mapProductToProductDTO(product);
    }

    @Override
    public void deleteProduct(long id) {
        log.info("delete product by id {}", id);
        productRepository.deleteProduct(id);
    }

    private ProductDTO mapProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .photo(product.getPhoto())
                .orderNumber(product.getOrderNumber())
                .build();
    }

    private Product mapProductDTOToProduct(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .categoryId(productDTO.getCategoryId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .status(productDTO.getStatus())
                .photo(productDTO.getPhoto())
                .orderNumber(productDTO.getOrderNumber())
                .build();
    }
}
