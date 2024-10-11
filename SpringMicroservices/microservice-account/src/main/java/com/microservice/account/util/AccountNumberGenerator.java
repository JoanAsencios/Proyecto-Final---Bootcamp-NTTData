package com.microservice.account.util;

public class AccountNumberGenerator {

    public static String numberGen(){
        String accountNumber = "";
        StringBuilder sAccountNumber = new StringBuilder();
            for(int i=0; i<=16; i++){
                int digit = (int) (Math.random() * 9) +1;
                sAccountNumber.append(digit);
            }
        accountNumber = sAccountNumber.toString();
        return accountNumber;
    }
}
