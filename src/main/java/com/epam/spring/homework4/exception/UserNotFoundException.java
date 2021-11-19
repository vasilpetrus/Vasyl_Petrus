package com.epam.spring.homework4.exception;

import com.epam.spring.homework4.error.enums.ErrorCode;
import com.epam.spring.homework4.error.enums.ErrorType;

public class UserNotFoundException extends AbstractException {

    public UserNotFoundException(String message){
        super(message);
    }
    @Override
    public ErrorCode getErrorCode(){
        return ErrorCode.APPLICATION_ERROR_CODE;
    }

    @Override
    public ErrorType getErrorType(){
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
