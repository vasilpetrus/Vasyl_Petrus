package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(long id);

    List<Order> getAllOrders();

    Order createOrder(Order order);

    Order updateOrder(long id, Order order);

    void deleteOrder(long id);
}
