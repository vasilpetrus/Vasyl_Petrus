package com.epam.spring.homework4.exception;

import com.epam.spring.homework4.error.enums.ErrorCode;
import com.epam.spring.homework4.error.enums.ErrorType;

public abstract class AbstractException extends RuntimeException {

    public AbstractException(String message){
        super(message);
    }

    public AbstractException(String message, Throwable cause){
        super(message, cause);
    }
    public ErrorCode getErrorCode(){
        return ErrorCode.APPLICATION_ERROR_CODE;
    }
    public ErrorType getErrorType(){
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
