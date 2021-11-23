package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserOrderDTO;

import java.util.List;

public interface UserOrderService {

    UserOrderDTO getUserOrder(long id);

    List<UserOrderDTO> getAllUserOrders();

    UserOrderDTO createUserOrder(UserOrderDTO userOrderDTO);

    void deleteUserOrder(long id);
}
