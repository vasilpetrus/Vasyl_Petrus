package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(long id);
}
