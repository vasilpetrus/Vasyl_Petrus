package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.OrderDAO;
import com.epam.spring.homework4.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderDAO orderDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order")
    public List<OrderDTO> getAllOrder() {
        return orderDAO.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrder(@PathVariable long id) {
        return orderDAO.getOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderDAO.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDTO updateOrder(@PathVariable long id, @RequestBody OrderDTO orderDTO) {
        return orderDAO.updateOrder(id, orderDTO);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        orderDAO.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
