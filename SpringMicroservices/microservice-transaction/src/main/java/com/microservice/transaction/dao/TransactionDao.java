package com.microservice.transaction.dao;

import com.microservice.transaction.model.Transaction;

import java.util.ArrayList;

public interface TransactionDao {

    void registerDeposito(Transaction trx);
    void registerRetiro(Transaction trx);
    void registerTransferencia(Transaction trx);
    ArrayList<Transaction> getAll();

}
