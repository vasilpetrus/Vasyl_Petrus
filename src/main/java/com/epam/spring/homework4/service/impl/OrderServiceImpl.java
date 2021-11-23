package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.mapper.OrderMapper;
import com.epam.spring.homework4.myRepository.OrderRepository;
import com.epam.spring.homework4.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrder(long id) {
        log.info("get order by id {}", id);
        Order order = orderRepository.findById(id);
        return OrderMapper.INSTANCE.mapOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        log.info("get all order");
        return OrderMapper.INSTANCE.mapOrderDto(orderRepository.findAll());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("create order with id {}", orderDTO.getId());
        Order order = OrderMapper.INSTANCE.mapOrder(orderDTO);
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.mapOrderDTO(order);
    }

    @Override
    public void deleteOrder(long id) {
        log.info("delete order by id {}", id);
        orderRepository.deleteById(id);
    }
}
