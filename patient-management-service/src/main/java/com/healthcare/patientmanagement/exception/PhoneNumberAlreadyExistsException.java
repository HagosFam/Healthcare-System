package com.healthcare.patientmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PhoneNumberAlreadyExistsException extends RuntimeException{
    String message;

    public PhoneNumberAlreadyExistsException(String message){
        super(message);
    }
}
