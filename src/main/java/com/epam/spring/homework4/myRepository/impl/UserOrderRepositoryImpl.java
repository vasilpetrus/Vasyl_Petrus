package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.UserOrder;
import com.epam.spring.homework4.myRepository.UserOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserOrderRepositoryImpl implements UserOrderRepository {

    private final List<UserOrder> listUserOrder = new ArrayList<>();

    @Override
    public UserOrder getUserOrder(long id) {
        return listUserOrder.stream()
                .filter(userOrder -> userOrder.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User order is not found!"));
    }

    @Override
    public List<UserOrder> getAllUserOrders() {
        return new ArrayList<>(listUserOrder);
    }

    @Override
    public UserOrder createUserOrder(UserOrder userOrder) {
        listUserOrder.add(userOrder);
        return userOrder;
    }

    @Override
    public UserOrder updateUserOrder(long id, UserOrder userOrder) {
        boolean isDeleted = listUserOrder.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listUserOrder.add(userOrder);
        } else {
            throw new RuntimeException("User order is not found!");
        }
        return userOrder;
    }

    @Override
    public void deleteUserOrder(long id) {
        listUserOrder.removeIf(userOrder -> userOrder.getId() == id);
    }
}
