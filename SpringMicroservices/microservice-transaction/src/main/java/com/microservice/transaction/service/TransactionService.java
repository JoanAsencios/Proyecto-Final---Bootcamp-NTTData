package com.microservice.transaction.service;

import com.microservice.transaction.dao.TransactionDao;
import com.microservice.transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public void registerDeposito(Transaction trx) {
        transactionDao.registerDeposito(trx);
    }

    public void registerRetiro(Transaction trx) {
        transactionDao.registerRetiro(trx);

    }

    public void registerTransferencia(Transaction trx) {
        transactionDao.registerTransferencia(trx);
    }

    public ArrayList<Transaction> getAll() {
        return transactionDao.getAll();
    }
}
