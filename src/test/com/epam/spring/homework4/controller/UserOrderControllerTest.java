package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.entity.UserOrder;
import com.epam.spring.homework4.mapper.UserOrderMapper;
import com.epam.spring.homework4.myRepository.UserOrderRepository;
import com.epam.spring.homework4.service.UserOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(value = UserOrderController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class UserOrderControllerTest {

    @MockBean
    private UserOrderService userOrderService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserOrderRepository userOrderRepository;

    @Spy
    private UserOrderMapper userOrderMapper = Mappers.getMapper(UserOrderMapper.class);

    private final long ID = 1;

    @Test
    void getAllUserOrders() throws Exception {

        UserOrderDTO userOrderDTO = UserOrderDTO
                .builder()
                .id(ID)
                .build();

        UserOrderDTO userOrder2DTO = UserOrderDTO
                .builder()
                .id(ID)
                .build();

        when(userOrderService.getAllUserOrders()).thenReturn(Arrays.asList(userOrderDTO, userOrder2DTO));

        mockMvc.perform(get("/user-order"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(userOrderDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(userOrder2DTO.getId()));

        verify(userOrderService, times(1)).getAllUserOrders();
    }

    @Test
    void getUserOrder() throws Exception {

        UserOrderDTO userOrderDTO = UserOrderDTO
                .builder()
                .id(ID)
                .build();

        when(userOrderService.getUserOrder(ID)).thenReturn(userOrderDTO);

        mockMvc
                .perform(get("/user-order/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userOrderDTO.getId()));
    }

    @Test
    void createUserOrder() {

        UserOrder userOrder = new UserOrder();
        userOrder.setId(ID);

        when(userOrderRepository.save(any(UserOrder.class))).thenReturn(userOrder);

        UserOrderDTO userOrderDTO = userOrderMapper.mapUserOrderDTO(userOrder);

        Assertions.assertEquals(userOrder.getId(), userOrderDTO.getId());
    }

    @Test
    void deleteUserOrder() throws Exception {

        doNothing().when(userOrderService).deleteUserOrder(ID);

        mockMvc.perform(delete("/user-order/" + ID))
                .andExpect(status().isNoContent());

        verify(userOrderService, times(1)).deleteUserOrder(ID);
    }
}