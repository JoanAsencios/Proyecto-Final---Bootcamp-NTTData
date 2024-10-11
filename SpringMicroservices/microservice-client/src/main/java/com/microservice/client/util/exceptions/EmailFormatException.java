package com.microservice.client.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Incorrect format email")
public class EmailFormatException extends RuntimeException{

    public EmailFormatException(String message){
        super(message);
    }

}
