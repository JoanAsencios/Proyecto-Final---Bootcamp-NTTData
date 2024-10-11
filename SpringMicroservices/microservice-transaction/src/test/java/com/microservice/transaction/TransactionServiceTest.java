package com.microservice.transaction;

import com.microservice.transaction.model.Transaction;
import com.microservice.transaction.service.TransactionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransactionServiceTest {

    Transaction trxDeposito;
    Transaction trxRetiro;
    Transaction trxTransferencia;
    TransactionService transactionService;

    @BeforeAll
    void init(){
        trxDeposito = new Transaction();
        trxDeposito.setId(10);
        trxDeposito.setIdCuentaOrig(20);
        trxDeposito.setTipo("Deposito");
        trxDeposito.setMonto(45);
        trxDeposito.setFecha("2024-11-10");

        trxRetiro = new Transaction();
        trxRetiro.setId(10);
        trxRetiro.setIdCuentaOrig(20);
        trxRetiro.setTipo("Retiro");
        trxRetiro.setMonto(80);
        trxRetiro.setFecha("2024-11-10");

        trxTransferencia = new Transaction();
        trxTransferencia.setId(10);
        trxTransferencia.setIdCuentaOrig(20);
        trxTransferencia.setIdCuentaDest(30);
        trxTransferencia.setTipo("Transferencia");
        trxTransferencia.setMonto(457);
        trxTransferencia.setFecha("2024-11-10");

        transactionService = new TransactionService();
    }

    @Test
    void depositar(){
        init();
        transactionService.registerDeposito(trxDeposito);
    }

    @Test
    void retirar(){
        init();
        transactionService.registerRetiro(trxRetiro);
    }

    @Test
    void transferir(){
        init();
        transactionService.registerTransferencia(trxTransferencia);
    }

    @Test
    void showHistorial(){
        init();
        transactionService.getAll();
    }

}
