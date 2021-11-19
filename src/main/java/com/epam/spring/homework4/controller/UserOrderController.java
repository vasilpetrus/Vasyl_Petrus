package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserOrderController {

    private final UserOrderService userOrderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-order")
    public List<UserOrderDTO> getAllUserOrders() {
        return userOrderService.getAllUserOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-order/{id}")
    public UserOrderDTO getUserOrder(@PathVariable long id) {
        return userOrderService.getUserOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user-order")
    public UserOrderDTO createUserOrder(@RequestBody @Valid UserOrderDTO userOrderDTO) {
        return userOrderService.createUserOrder(userOrderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user-order/{id}")
    public UserOrderDTO updateUserOrder(@PathVariable long id, @RequestBody @Valid UserOrderDTO userOrderDTO) {
        return userOrderService.updateUserOrder(id, userOrderDTO);
    }

    @DeleteMapping(value = "/user-order/{id}")
    public ResponseEntity<Void> deleteUserOrder(@PathVariable long id) {
        userOrderService.deleteUserOrder(id);
        return ResponseEntity.noContent().build();
    }
}
