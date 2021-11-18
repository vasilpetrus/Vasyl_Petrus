package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.service.UserInformationService;
import com.epam.spring.homework4.dto.UserInformationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserInformationController {

    private final UserInformationService userInformationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-information")
    public List<UserInformationDTO> getAllUsersInformation() {
        return userInformationService.getAllUsersInformation();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-information/{id}")
    public UserInformationDTO getUserInformation(@PathVariable long id) {
        return userInformationService.getUserInformation(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user-information")
    public UserInformationDTO createUserInformation(@RequestBody @Valid UserInformationDTO userInformationDTO) {
        return userInformationService.createUserInformation(userInformationDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user-information/{id}")
    public UserInformationDTO updateUserInformation(@PathVariable long id, @RequestBody @Valid UserInformationDTO userInformationDTO) {
        return userInformationService.updateUserInformation(id, userInformationDTO);
    }

    @DeleteMapping(value = "/user-information/{id}")
    public ResponseEntity<Void> deleteUserInformation(@PathVariable long id) {
        userInformationService.deleteUserInformation(id);
        return ResponseEntity.noContent().build();
    }
}
