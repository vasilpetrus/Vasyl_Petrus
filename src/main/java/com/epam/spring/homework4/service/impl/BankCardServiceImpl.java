package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.service.BankCardService;
import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.mapper.BankCardMapper;
import com.epam.spring.homework4.myRepository.BankCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankCardServiceImpl implements BankCardService {

    private final BankCardRepository bankCardRepository;

    @Override
    public BankCardDTO getBankCard(long id) {
        log.info("get bank card information by id {}", id);
        BankCard bankCard = bankCardRepository.getBankCard(id);
        return BankCardMapper.INSTANCE.mapBankCardDTO(bankCard);
    }

    @Override
    public List<BankCardDTO> getAllBankCard() {
        log.info("get all bank cards information");
        return BankCardMapper.INSTANCE.mapBankCardDto(bankCardRepository.getAllBankCards());
    }

    @Override
    public BankCardDTO createBankCard(BankCardDTO bankCardDTO) {
        log.info("create bank card information with id {}", bankCardDTO.getId());
        BankCard bankCard = BankCardMapper.INSTANCE.mapBankCard(bankCardDTO);
        bankCard = bankCardRepository.createBankCard(bankCard);
        return BankCardMapper.INSTANCE.mapBankCardDTO(bankCard);
    }

    @Override
    public BankCardDTO updateBankCard(long id, BankCardDTO bankCardDto) {
        log.info("update bank card information with id {}", id);
        BankCard bankCard = BankCardMapper.INSTANCE.mapBankCard(bankCardDto);
        bankCard = bankCardRepository.updateBankCard(id, bankCard);
        return BankCardMapper.INSTANCE.mapBankCardDTO(bankCard);
    }

    @Override
    public void deleteBankCard(long id) {
        log.info("delete bank card information by id {}", id);
        bankCardRepository.deleteBankCard(id);
    }
}
