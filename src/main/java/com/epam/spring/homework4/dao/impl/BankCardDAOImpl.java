package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.BankCardDAO;
import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.myRepository.BankCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankCardDAOImpl implements BankCardDAO {

    private final BankCardRepository bankCardRepository;

    @Override
    public BankCardDTO getBankCard(long id) {
        log.info("get bank card information by id {}", id);
        BankCard bankCard = bankCardRepository.getBankCard(id);
        return mapBankCardToBankCardDTO(bankCard);
    }

    @Override
    public List<BankCardDTO> getAllBankCard() {
        log.info("get all bank cards information");
        return bankCardRepository.getAllBankCards()
                .stream()
                .map(this::mapBankCardToBankCardDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BankCardDTO createBankCard(BankCardDTO bankCardDTO) {
        log.info("create bank card information with id {}", bankCardDTO.getId());
        BankCard bankCard = mapBankCardDTOToBankCard(bankCardDTO);
        bankCard = bankCardRepository.createBankCard(bankCard);
        return mapBankCardToBankCardDTO(bankCard);
    }

    @Override
    public BankCardDTO updateBankCard(long id, BankCardDTO bankCardDto) {
        log.info("update bank card information with id {}", id);
        BankCard bankCard = mapBankCardDTOToBankCard(bankCardDto);
        bankCard = bankCardRepository.updateBankCard(id, bankCard);
        return mapBankCardToBankCardDTO(bankCard);
    }

    @Override
    public void deleteBankCard(long id) {
        log.info("delete bank card information by id {}", id);
        bankCardRepository.deleteBankCard(id);
    }

    private BankCardDTO mapBankCardToBankCardDTO(BankCard bankCard) {
        return BankCardDTO.builder()
                .id(bankCard.getId())
                .userInformationId(bankCard.getUserInformationId())
                .cardNumber(bankCard.getCardNumber())
                .expirationYear(bankCard.getExpirationYear())
                .expirationMonth(bankCard.getExpirationMonth())
                .cardOwner(bankCard.getCardOwner())
                .cvv(bankCard.getCvv())
                .balance(bankCard.getBalance())
                .build();
    }

    private BankCard mapBankCardDTOToBankCard(BankCardDTO bankCardDTO) {
        return BankCard.builder()
                .id(bankCardDTO.getId())
                .userInformationId(bankCardDTO.getUserInformationId())
                .cardNumber(bankCardDTO.getCardNumber())
                .expirationYear(bankCardDTO.getExpirationYear())
                .expirationMonth(bankCardDTO.getExpirationMonth())
                .cardOwner(bankCardDTO.getCardOwner())
                .cvv(bankCardDTO.getCvv())
                .balance(bankCardDTO.getBalance())
                .build();
    }
}
