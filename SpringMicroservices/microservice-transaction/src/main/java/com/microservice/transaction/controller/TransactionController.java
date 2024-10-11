package com.microservice.transaction.controller;

import com.microservice.transaction.model.Transaction;
import com.microservice.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/register/deposito")
    public void registerDeposito(@RequestBody Transaction trx) {
        transactionService.registerDeposito(trx);
    }

    @PostMapping("/register/retiro")
    public void registerRetiro(@RequestBody Transaction trx) {
        transactionService.registerRetiro(trx);
    }

    @PostMapping("/register/trasferencia")
    public void registerTransferencia(@RequestBody Transaction trx) {
        transactionService.registerTransferencia(trx);
    }

    @GetMapping("/search/historial")
    public ArrayList<Transaction> getAll() {
        return transactionService.getAll();
    }
}
