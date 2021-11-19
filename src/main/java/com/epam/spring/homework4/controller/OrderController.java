package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order")
    public List<OrderDTO> getAllOrder() {
        return orderService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDTO updateOrder(@PathVariable long id, @RequestBody @Valid OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
