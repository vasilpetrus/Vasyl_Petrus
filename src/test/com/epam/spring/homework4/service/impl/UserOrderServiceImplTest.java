package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.entity.UserOrder;
import com.epam.spring.homework4.mapper.UserOrderMapper;
import com.epam.spring.homework4.myRepository.UserOrderRepository;
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
class UserOrderServiceImplTest {

    @InjectMocks
    private UserOrderServiceImpl userOrderService;

    @Mock
    private UserOrderRepository userOrderRepository;

    @Spy
    private UserOrderMapper userOrderMapper = Mappers.getMapper(UserOrderMapper.class);

    private final long ID = 1;

    @Test
    void getUserOrder() {

        UserOrder userOrder = new UserOrder();
        userOrder.setId(ID);
        when(userOrderRepository.findById(ID)).thenReturn(userOrder);

        UserOrderDTO userOrderDTO= userOrderService.getUserOrder(ID);

        assertEquals(userOrder.getId(), userOrderDTO.getId());
    }

    @Test
    void getAllUserOrders() {

        UserOrder userOrder1 = new UserOrder();
        UserOrder userOrder2 = new UserOrder();
        userOrder1.setId(ID);
        userOrder2.setId(ID);

        when(userOrderRepository.findAll()).thenReturn(Arrays.asList(userOrder1, userOrder2));

        List<UserOrderDTO> resultList = userOrderService.getAllUserOrders();

        assertEquals(2, resultList.size());
    }

    @Test
    void createUserOrder() {

        UserOrder userOrder = new UserOrder();
        userOrder.setId(ID);

        when(userOrderRepository.save(any(UserOrder.class))).thenReturn(userOrder);

        UserOrderDTO userOrderDTO = userOrderService.createUserOrder(userOrderMapper.mapUserOrderDTO(userOrder));

        assertEquals(userOrderDTO.getId(), userOrder.getId());
    }

    @Test
    void deleteUserOrder() {

        doNothing().when(userOrderRepository).deleteById(ID);

        userOrderService.deleteUserOrder(ID);

        verify(userOrderRepository, times(1)).deleteById(ID);
    }
}