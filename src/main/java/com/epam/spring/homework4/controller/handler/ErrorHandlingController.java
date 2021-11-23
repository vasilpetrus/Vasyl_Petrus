package com.epam.spring.homework4.controller.handler;

import com.epam.spring.homework4.error.Error;
import com.epam.spring.homework4.error.enums.ErrorCode;
import com.epam.spring.homework4.error.enums.ErrorType;
import com.epam.spring.homework4.exception.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        log.error("handleMethodNotValidArgumentException: exception {}", ex.getMessage(), ex);
        return ex.getBindingResult().getAllErrors().stream()
                .map(err -> new Error(err.getDefaultMessage(), ErrorCode.VALIDATION_ERROR_CODE,
                        ErrorType.PROCESSING_ERROR_TYPE, LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(AbstractException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleAbstractException(AbstractException ex, HandlerMethod hm){
        log.error("handleAbstractException: exception {}, method{}",
                ex.getMessage(), hm.getMethod().getName(), ex);
        return new Error(ex.getMessage(), ex.getErrorCode(), ex.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleAllException(Exception ex, HandlerMethod hm){
        log.error("handlerAllException: exception {}, method {}",
                ex.getMessage(), hm.getMethod().getName(), ex);
        return new Error(ex.getMessage(), ErrorCode.APPLICATION_ERROR_CODE, ErrorType.FATAL_ERROR_TYPE,
                LocalDateTime.now());
    }
}
