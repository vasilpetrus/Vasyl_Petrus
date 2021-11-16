package com.epam.spring.homework4.dao;

import com.epam.spring.homework4.dto.UserOrderDTO;

import java.util.List;

public interface UserOrderDAO {

    UserOrderDTO getUserOrder(long id);

    List<UserOrderDTO> getAllUserOrders();

    UserOrderDTO createUserOrder(UserOrderDTO userOrderDTO);

    UserOrderDTO updateUserOrder(long id, UserOrderDTO userOrderDTO);

    void deleteUserOrder(long id);
}
