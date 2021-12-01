package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.mapper.OrderMapper;
import com.epam.spring.homework4.myRepository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Spy
    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    private final long ID = 1;

    @Test
    void getOrder() {

        Order order = new Order();
        order.setId(ID);
        when(orderRepository.findById(ID)).thenReturn(order);

        OrderDTO orderDTO = orderService.getOrder(ID);

        assertEquals(order.getId(), orderDTO.getId());
    }

    @Test
    void getAllOrders() {

        Order order1 = new Order();
        Order order2 = new Order();
        order1.setId(ID);
        order2.setId(ID);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<OrderDTO> resultList = orderService.getAllOrders();

        assertEquals(2, resultList.size());
    }

    @Test
    void createOrder() {

        Order order = new Order();
        order.setId(ID);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDTO orderDTO = orderService.createOrder(orderMapper.mapOrderDTO(order));

        assertEquals(orderDTO.getId(), order.getId());
    }

    @Test
    void deleteOrder() {

        doNothing().when(orderRepository).deleteById(ID);

        orderService.deleteOrder(ID);

        verify(orderRepository, times(1)).deleteById(ID);
    }
}