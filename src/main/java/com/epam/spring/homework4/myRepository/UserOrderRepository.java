package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.UserOrder;

import java.util.List;

public interface UserOrderRepository {

    UserOrder getUserOrder(long id);

    List<UserOrder> getAllUserOrders();

    UserOrder createUserOrder(UserOrder userOrder);

    UserOrder updateUserOrder(long id, UserOrder userOrder);

    void deleteUserOrder(long id);
}
