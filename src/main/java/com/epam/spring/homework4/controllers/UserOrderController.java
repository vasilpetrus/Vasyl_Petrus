package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.UserOrderDAO;
import com.epam.spring.homework4.dto.UserOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserOrderController {

    private final UserOrderDAO userOrderDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-order")
    public List<UserOrderDTO> getAllUserOrders() {
        return userOrderDAO.getAllUserOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-order/{id}")
    public UserOrderDTO getUserOrder(@PathVariable long id) {
        return userOrderDAO.getUserOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user-order")
    public UserOrderDTO createUserOrder(@RequestBody UserOrderDTO userOrderDTO) {
        return userOrderDAO.createUserOrder(userOrderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user-order/{id}")
    public UserOrderDTO updateUserOrder(@PathVariable long id, @RequestBody UserOrderDTO userOrderDTO) {
        return userOrderDAO.updateUserOrder(id, userOrderDTO);
    }

    @DeleteMapping(value = "/user-order/{id}")
    public ResponseEntity<Void> deleteUserOrder(@PathVariable long id) {
        userOrderDAO.deleteUserOrder(id);
        return ResponseEntity.noContent().build();
    }
}
