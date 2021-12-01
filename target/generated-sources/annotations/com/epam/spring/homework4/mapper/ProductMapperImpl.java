package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.CategoryDTO;
import com.epam.spring.homework4.dto.CategoryDTO.CategoryDTOBuilder;
import com.epam.spring.homework4.dto.ProductDTO;
import com.epam.spring.homework4.dto.ProductDTO.ProductDTOBuilder;
import com.epam.spring.homework4.entity.Category;
import com.epam.spring.homework4.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-30T18:01:46+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductDTO> mapProductDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( mapProductDTO( product ) );
        }

        return list;
    }

    @Override
    public ProductDTO mapProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.id( product.getId() );
        productDTO.category( categoryToCategoryDTO( product.getCategory() ) );
        productDTO.name( product.getName() );
        productDTO.description( product.getDescription() );
        productDTO.price( product.getPrice() );
        productDTO.status( product.getStatus() );
        productDTO.photo( product.getPhoto() );
        productDTO.orderNumber( product.getOrderNumber() );

        return productDTO.build();
    }

    @Override
    public Product mapProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setCategory( categoryDTOToCategory( productDTO.getCategory() ) );
        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );
        product.setPrice( productDTO.getPrice() );
        product.setStatus( productDTO.getStatus() );
        product.setPhoto( productDTO.getPhoto() );
        product.setOrderNumber( productDTO.getOrderNumber() );

        return product;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.id( category.getId() );
        categoryDTO.category( category.getCategory() );

        return categoryDTO.build();
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setCategory( categoryDTO.getCategory() );

        return category;
    }
}
