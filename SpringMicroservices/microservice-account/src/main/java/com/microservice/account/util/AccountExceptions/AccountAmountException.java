package com.microservice.account.util.AccountExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect Amount")
public class AccountAmountException extends RuntimeException{

    public AccountAmountException(String message){
        super(message);
    }

}
