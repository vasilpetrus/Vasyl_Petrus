package com.epam.spring.homework4.error;

import com.epam.spring.homework4.error.enums.ErrorCode;
import com.epam.spring.homework4.error.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
    private String message;
    private ErrorCode errorCode;
    private ErrorType errorType;
    private LocalDateTime dateTime;
}
