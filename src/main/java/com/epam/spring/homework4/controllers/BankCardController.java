package com.epam.spring.homework4.controllers;

import com.epam.spring.homework4.dao.BankCardDAO;
import com.epam.spring.homework4.dto.BankCardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankCardController {

    private final BankCardDAO bankCardDAO;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/bankcard")
    public List<BankCardDTO> getAllBankCard() {
        return bankCardDAO.getAllBankCard();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/bankcard/{id}")
    public BankCardDTO getBankCard(@PathVariable long id) {
        return bankCardDAO.getBankCard(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/bankcard")
    public BankCardDTO createBankCard(@RequestBody BankCardDTO bankCardDTO) {
        return bankCardDAO.createBankCard(bankCardDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/bankcard/{id}")
    public BankCardDTO updateBankCard(@PathVariable long id, @RequestBody BankCardDTO bankCardDTO) {
        return bankCardDAO.updateBankCard(id, bankCardDTO);
    }

    @DeleteMapping(value = "/bankcard/{id}")
    public ResponseEntity<Void> deleteBankCard(@PathVariable long id) {
        bankCardDAO.deleteBankCard(id);
        return ResponseEntity.noContent().build();
    }
}
