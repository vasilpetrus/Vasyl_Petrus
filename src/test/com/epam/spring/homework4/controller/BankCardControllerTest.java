package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.mapper.BankCardMapper;
import com.epam.spring.homework4.myRepository.BankCardRepository;
import com.epam.spring.homework4.service.BankCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(value = BankCardController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class BankCardControllerTest {

    @MockBean
    private BankCardService bankCardService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BankCardRepository bankCardRepository;

    @Spy
    private BankCardMapper bankCardMapper = Mappers.getMapper(BankCardMapper.class);

    private final long ID = 1;

    @Test
    void getAllBankCard() throws Exception {

        BankCardDTO bankCardDTO = BankCardDTO
                .builder()
                .id(1)
                .build();

        BankCardDTO bankCardDTO2 = BankCardDTO
                .builder()
                .id(2)
                .build();

        when(bankCardService.getAllBankCard()).thenReturn(Arrays.asList(bankCardDTO, bankCardDTO2));

        mockMvc.perform(get("/bankcard"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(bankCardDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(bankCardDTO2.getId()));

        verify(bankCardService, times(1)).getAllBankCard();
    }

    @Test
    void getBankCard() throws Exception {

        BankCardDTO bankCardDTO = BankCardDTO
                .builder()
                .id(ID)
                .build();

        when(bankCardService.getBankCard(ID)).thenReturn(bankCardDTO);

        mockMvc
                .perform(get("/bankcard/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(bankCardDTO.getId()));
    }

    @Test
    void createBankCard() {

        BankCard bankCard = new BankCard();
        bankCard.setId(ID);

        when(bankCardRepository.save(any(BankCard.class))).thenReturn(bankCard);

        BankCardDTO bankCardDTO = bankCardMapper.mapBankCardDTO(bankCard);

        Assertions.assertEquals(bankCard.getId(), bankCardDTO.getId());
    }

    @Test
    void deleteBankCard() throws Exception {

        doNothing().when(bankCardService).deleteBankCard(ID);

        mockMvc.perform(delete("/bankcard/" + ID))
                .andExpect(status().isNoContent());

        verify(bankCardService, times(1)).deleteBankCard(ID);
    }
}