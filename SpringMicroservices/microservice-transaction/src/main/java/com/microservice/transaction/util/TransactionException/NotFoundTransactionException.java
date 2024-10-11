package com.microservice.transaction.util.TransactionException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
public class NotFoundTransactionException extends RuntimeException{

    public NotFoundTransactionException(String message){
        super(message);
    }
}
