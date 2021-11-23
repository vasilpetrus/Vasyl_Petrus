package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankCardController {

    private final BankCardService bankCardService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/bankcard")
    public List<BankCardDTO> getAllBankCard() {
        return bankCardService.getAllBankCard();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/bankcard/{id}")
    public BankCardDTO getBankCard(@PathVariable long id) {
        return bankCardService.getBankCard(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/bankcard")
    public BankCardDTO createBankCard(@RequestBody @Valid BankCardDTO bankCardDTO) {
        return bankCardService.createBankCard(bankCardDTO);
    }

    @DeleteMapping(value = "/bankcard/{id}")
    public ResponseEntity<Void> deleteBankCard(@PathVariable long id) {
        bankCardService.deleteBankCard(id);
        return ResponseEntity.noContent().build();
    }
}
