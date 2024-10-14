package com.microservice.transaction;

import com.microservice.transaction.dao.TransactionDao;
import com.microservice.transaction.model.Transaction;
import com.microservice.transaction.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    TransactionDao transactionDao;

    @InjectMocks
    TransactionService transactionService;

    Transaction trxDeposito = new Transaction();
    Transaction trxRetiro = new Transaction();
    Transaction trxTransferencia = new Transaction();
    ArrayList<Transaction> trxList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        trxDeposito.setId(20);
        trxDeposito.setIdCuentaOrig(20);
        trxDeposito.setTipo("Deposito");
        trxDeposito.setMonto(45);
        trxDeposito.setFecha("2024-11-10");

        trxRetiro.setId(30);
        trxRetiro.setIdCuentaOrig(20);
        trxRetiro.setTipo("Retiro");
        trxRetiro.setMonto(80);
        trxRetiro.setFecha("2024-11-10");

        trxTransferencia.setId(40);
        trxTransferencia.setIdCuentaOrig(20);
        trxTransferencia.setIdCuentaDest(30);
        trxTransferencia.setTipo("Transferencia");
        trxTransferencia.setMonto(457);
        trxTransferencia.setFecha("2024-11-10");

        trxList.add(trxDeposito);
        trxList.add(trxRetiro);
        trxList.add(trxTransferencia);
    }

    @Test
    void depositar(){
        Mockito.doNothing().when(transactionDao).registerDeposito(trxDeposito);
        transactionService.registerDeposito(trxDeposito);
        Mockito.verify(transactionDao, Mockito.times(1)).registerDeposito(trxDeposito);
    }

    @Test
    void retirar(){
        Mockito.doNothing().when(transactionDao).registerRetiro(trxRetiro);
        transactionService.registerRetiro(trxRetiro);
        Mockito.verify(transactionDao, Mockito.times(1)).registerRetiro(trxRetiro);
    }

    @Test
    void transferir(){
        Mockito.doNothing().when(transactionDao).registerTransferencia(trxTransferencia);
        transactionService.registerTransferencia(trxTransferencia);
        Mockito.verify(transactionDao, Mockito.times(1)).registerTransferencia(trxTransferencia);
    }

    @Test
    void showHistorial(){
        Mockito.when(transactionDao.getAll())
                .thenReturn(trxList);

        final ArrayList<Transaction> resultTrx = transactionService.getAll();
        Assertions.assertNotNull(resultTrx);
        Assertions.assertEquals(trxList, resultTrx);
        Mockito.verify(transactionDao, Mockito.times(1)).getAll();
    }

}
