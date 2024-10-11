package com.microservice.client.util;

import com.microservice.client.util.exceptions.EmailFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static void emValidator(String email){
        boolean approve = false;
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        approve = matcher.find();
            if(approve != true){
                throw new EmailFormatException("Formato de email no valido");
            }
    }
}
