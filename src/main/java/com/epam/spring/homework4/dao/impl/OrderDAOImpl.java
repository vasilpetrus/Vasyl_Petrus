package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.OrderDAO;
import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.myRepository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrder(long id) {
        log.info("get order by id {}", id);
        Order order = orderRepository.getOrder(id);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        log.info("get all order");
        return orderRepository.getAllOrders()
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("create order with id {}", orderDTO.getId());
        Order order = mapOrderDTOToOrder(orderDTO);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(long id, OrderDTO orderDTO) {
        log.info("update order with id {}", id);
        Order order = mapOrderDTOToOrder(orderDTO);
        order = orderRepository.updateOrder(id, order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(long id) {
        log.info("delete order by id {}", id);
        orderRepository.deleteOrder(id);
    }

    private OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .userId(order.getUserId())
                .userOrderId(order.getUserOrderId())
                .number(order.getNumber())
                .build();
    }

    private Order mapOrderDTOToOrder(OrderDTO orderDTO) {
        return Order.builder()
                .id(orderDTO.getId())
                .productId(orderDTO.getProductId())
                .userId(orderDTO.getUserId())
                .userOrderId(orderDTO.getUserOrderId())
                .number(orderDTO.getNumber())
                .build();
    }
}
