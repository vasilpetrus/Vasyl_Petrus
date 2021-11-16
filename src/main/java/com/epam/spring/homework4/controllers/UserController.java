package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.UserDAO;
import com.epam.spring.homework4.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDAO userDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{email}")
    public UserDTO getUser(@PathVariable String email) {
        return userDAO.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userDAO.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{email}")
    public UserDTO updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        return userDAO.updateUser(email, userDTO);
    }

    @DeleteMapping(value = "/user/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userDAO.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
