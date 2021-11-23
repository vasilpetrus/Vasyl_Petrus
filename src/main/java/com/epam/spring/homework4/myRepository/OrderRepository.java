package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);

    List<Order> findAll();

    Order save(Order order);

    void deleteById(long id);
}
