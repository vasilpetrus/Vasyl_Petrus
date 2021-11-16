package com.epam.spring.homework4.dao;

import com.epam.spring.homework4.dto.OrderDTO;

import java.util.List;

public interface OrderDAO {

    OrderDTO getOrder(long id);

    List<OrderDTO> getAllOrders();

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(long id, OrderDTO orderDTO);

    void deleteOrder(long id);
}
