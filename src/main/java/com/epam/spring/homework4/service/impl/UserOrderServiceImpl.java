package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.entity.UserOrder;
import com.epam.spring.homework4.mapper.UserOrderMapper;
import com.epam.spring.homework4.myRepository.UserOrderRepository;
import com.epam.spring.homework4.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOrderServiceImpl implements UserOrderService {

    private final UserOrderRepository userOrderRepository;

    @Override
    public UserOrderDTO getUserOrder(long id) {
        log.info("get user order by id {}", id);
        UserOrder userOrder = userOrderRepository.getUserOrder(id);
        return UserOrderMapper.INSTANCE.mapUserOrderDTO(userOrder);
    }

    @Override
    public List<UserOrderDTO> getAllUserOrders() {
        log.info("get all user orders");
        return UserOrderMapper.INSTANCE.mapUsersOrderDto(userOrderRepository.getAllUserOrders());
    }

    @Override
    public UserOrderDTO createUserOrder(UserOrderDTO userOrderDTO) {
        log.info("create user order with id {}", userOrderDTO.getId());
        UserOrder userOrder = UserOrderMapper.INSTANCE.mapUserOrder(userOrderDTO);
        userOrder = userOrderRepository.createUserOrder(userOrder);
        return UserOrderMapper.INSTANCE.mapUserOrderDTO(userOrder);
    }

    @Override
    public UserOrderDTO updateUserOrder(long id, UserOrderDTO userOrderDTO) {
        log.info("update user order with id {}", id);
        UserOrder userOrder = UserOrderMapper.INSTANCE.mapUserOrder(userOrderDTO);
        userOrder = userOrderRepository.updateUserOrder(id, userOrder);
        return UserOrderMapper.INSTANCE.mapUserOrderDTO(userOrder);
    }

    @Override
    public void deleteUserOrder(long id) {
        log.info("delete user order by id {}", id);
        userOrderRepository.deleteUserOrder(id);
    }
}
