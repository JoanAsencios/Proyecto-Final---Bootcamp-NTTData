package com.microservice.transaction.util.TransactionException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class BadRequestTransactionException extends RuntimeException{

    public BadRequestTransactionException(String message){
        super(message);
    }

}
