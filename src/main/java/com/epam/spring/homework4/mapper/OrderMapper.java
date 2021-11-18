package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderDTO> mapOrderDto(List<Order>orders);

    OrderDTO mapOrderDTO(Order order);

    Order mapOrder(OrderDTO orderDTO);
}
