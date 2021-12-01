package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.mapper.OrderMapper;
import com.epam.spring.homework4.myRepository.OrderRepository;
import com.epam.spring.homework4.service.OrderService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(value = OrderController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderRepository orderRepository;

    @Spy
    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    private final long ID = 1;

    @Test
    void getAllOrder() throws Exception {

        OrderDTO orderDTO = OrderDTO
                .builder()
                .id(1)
                .build();

        OrderDTO orderDTO2 = OrderDTO
                .builder()
                .id(2)
                .build();

        when(orderService.getAllOrders()).thenReturn(Arrays.asList(orderDTO, orderDTO2));

        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(orderDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(orderDTO2.getId()));

        verify(orderService, times(1)).getAllOrders();
    }

    @Test
    void getOrder() throws Exception {

        OrderDTO orderDTO = OrderDTO
                .builder()
                .id(ID)
                .build();

        when(orderService.getOrder(ID)).thenReturn(orderDTO);

        mockMvc
                .perform(get("/order/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(orderDTO.getId()));
    }

    @Test
    void createOrder() {

        Order order= new Order();
        order.setId(ID);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDTO orderDTO = orderMapper.mapOrderDTO(order);

        Assertions.assertEquals(order.getId(), orderDTO.getId());
    }

    @Test
    void deleteOrder() throws Exception {

        doNothing().when(orderService).deleteOrder(ID);

        mockMvc.perform(delete("/order/" + ID))
                .andExpect(status().isNoContent());

        verify(orderService, times(1)).deleteOrder(ID);
    }
}