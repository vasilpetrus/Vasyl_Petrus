package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.UserInformationDAO;
import com.epam.spring.homework4.dto.UserInformationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserInformationController {

    private final UserInformationDAO userInformationDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-information")
    public List<UserInformationDTO> getAllUsersInformation() {
        return userInformationDAO.getAllUsersInformation();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-information/{id}")
    public UserInformationDTO getUserInformation(@PathVariable long id) {
        return userInformationDAO.getUserInformation(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user-information")
    public UserInformationDTO createUserInformation(@RequestBody UserInformationDTO userInformationDTO) {
        return userInformationDAO.createUserInformation(userInformationDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user-information/{id}")
    public UserInformationDTO updateUserInformation(@PathVariable long id, @RequestBody UserInformationDTO userInformationDTO) {
        return userInformationDAO.updateUserInformation(id, userInformationDTO);
    }

    @DeleteMapping(value = "/user-information/{id}")
    public ResponseEntity<Void> deleteUserInformation(@PathVariable long id) {
        userInformationDAO.deleteUserInformation(id);
        return ResponseEntity.noContent().build();
    }
}
