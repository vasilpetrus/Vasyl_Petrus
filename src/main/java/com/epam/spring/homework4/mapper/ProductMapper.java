package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDTO> mapProductDto(List<Product>products);

    ProductDTO mapProductDTO(Product product);

    Product mapProduct(ProductDTO productDTO);
}
