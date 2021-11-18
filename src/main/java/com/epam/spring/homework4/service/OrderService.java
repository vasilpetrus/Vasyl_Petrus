package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO getOrder(long id);

    List<OrderDTO> getAllOrders();

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(long id, OrderDTO orderDTO);

    void deleteOrder(long id);
}
