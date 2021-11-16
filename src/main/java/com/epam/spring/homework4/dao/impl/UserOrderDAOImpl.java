package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.UserOrderDAO;
import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.entity.UserOrder;
import com.epam.spring.homework4.myRepository.UserOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOrderDAOImpl implements UserOrderDAO {

    private final UserOrderRepository userOrderRepository;

    @Override
    public UserOrderDTO getUserOrder(long id) {
        log.info("get user order by id {}", id);
        UserOrder userOrder = userOrderRepository.getUserOrder(id);
        return mapUserOrderToUserOrderDTO(userOrder);
    }

    @Override
    public List<UserOrderDTO> getAllUserOrders() {
        log.info("get all user orders");
        return userOrderRepository.getAllUserOrders()
                .stream()
                .map(this::mapUserOrderToUserOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrderDTO createUserOrder(UserOrderDTO userOrderDTO) {
        log.info("create user order with id {}", userOrderDTO.getId());
        UserOrder userOrder = mapUserOrderDTOToUserOrder(userOrderDTO);
        userOrder = userOrderRepository.createUserOrder(userOrder);
        return mapUserOrderToUserOrderDTO(userOrder);
    }

    @Override
    public UserOrderDTO updateUserOrder(long id, UserOrderDTO userOrderDTO) {
        log.info("update user order with id {}", id);
        UserOrder userOrder = mapUserOrderDTOToUserOrder(userOrderDTO);
        userOrder = userOrderRepository.updateUserOrder(id, userOrder);
        return mapUserOrderToUserOrderDTO(userOrder);
    }

    @Override
    public void deleteUserOrder(long id) {
        log.info("delete user order by id {}", id);
        userOrderRepository.deleteUserOrder(id);
    }

    private UserOrderDTO mapUserOrderToUserOrderDTO(UserOrder userOrder) {
        return UserOrderDTO.builder()
                .id(userOrder.getId())
                .address(userOrder.getAddress())
                .orderDate(userOrder.getOrderDate())
                .deliveryDate(userOrder.getDeliveryDate())
                .status(userOrder.getStatus())
                .build();
    }

    private UserOrder mapUserOrderDTOToUserOrder(UserOrderDTO userOrderDTO) {
        return UserOrder.builder()
                .id(userOrderDTO.getId())
                .address(userOrderDTO.getAddress())
                .orderDate(userOrderDTO.getOrderDate())
                .deliveryDate(userOrderDTO.getDeliveryDate())
                .status(userOrderDTO.getStatus())
                .build();
    }
}
