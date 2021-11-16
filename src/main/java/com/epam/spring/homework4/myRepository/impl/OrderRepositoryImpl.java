package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.myRepository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> listOrder = new ArrayList<>();

    @Override
    public Order getOrder(long id) {
        return listOrder.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(listOrder);
    }

    @Override
    public Order createOrder(Order order) {
        listOrder.add(order);
        return order;
    }

    @Override
    public Order updateOrder(long id, Order order) {
        boolean isDeleted = listOrder.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listOrder.add(order);
        } else {
            throw new RuntimeException("Order is not found!");
        }
        return order;
    }

    @Override
    public void deleteOrder(long id) {
       listOrder.removeIf(order -> order.getId() == id);
    }
}
