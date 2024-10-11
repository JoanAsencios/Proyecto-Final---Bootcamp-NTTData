package com.microservice.account.service;

import com.microservice.account.client.Client;
import com.microservice.account.client.TransactionClient;
import com.microservice.account.dao.AccountDao;
import com.microservice.account.dto.ClientDTO;
import com.microservice.account.dto.TransactionDTO;
import com.microservice.account.model.Account;
import com.microservice.account.util.AccountExceptions.AccountAmountException;
import com.microservice.account.util.AccountExceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionClient transactionClient;

    @Autowired
    Client client;

    public Account register(Account account) {
        //Validar que cliente exista
        ClientDTO clientDTo = client.getById(account.getIdCliente());
            if(clientDTo != null){
                //Validar que el saldo sea mayor a 0
                if(account.getSaldo() > 0){
                    return accountDao.register(account);
                }else{
                    throw new AccountAmountException("Saldo debe ser mayor a 0");
                }
            }else{
                throw new AccountNotFoundException("Cliente no existe");
            }

    }

    public ArrayList<Account> getAll() {
        return accountDao.getAll();
    }

    public Account getById(long id) {
        return accountDao.getById(id);
    }

    public void depositar(TransactionDTO trx) {
        Account account = getById(trx.getIdCuentaOrig());
        int active = (account != null) ? account.getStatus() : 2;
        double amount = 0;
        double saldo = 0;
        double newSaldo = 0;
        //Valida si la cuenta esta activa
            if(active == 1){
                amount = trx.getMonto();
                saldo = account.getSaldo();
                newSaldo = amount + saldo;
                account.setSaldo(newSaldo);
                transactionClient.registerDeposito(trx);
                accountDao.update(account);
            }else{
                throw new AccountNotFoundException("Cuenta no está registrada o está inactiva");
            }
    }

    public void retirar(TransactionDTO trx) {
        Account account = getById(trx.getIdCuentaOrig());
        int active = (account != null) ? account.getStatus() : 2;
        double amount = 0;
        double saldo = 0;
        double newSaldo = 0;
        //Valida si la cuenta esta activa
        if(active == 1){
            int tipoCuenta = account.getTipoCuenta();
            amount = trx.getMonto();
            saldo = account.getSaldo();
                if(amount <= saldo && tipoCuenta == 1){
                    newSaldo = saldo - amount;
                    account.setSaldo(newSaldo);
                    transactionClient.registerRetiro(trx);
                    accountDao.update(account);

                }else if(tipoCuenta == 2){
                    newSaldo = saldo - amount;
                        if(newSaldo >= -500){
                            account.setSaldo(newSaldo);
                            transactionClient.registerRetiro(trx);
                            accountDao.update(account);
                        }else{
                            throw new AccountAmountException("Saldo no disponible");
                        }
                }else{
                    throw new AccountAmountException("Retiro no puede se mayor a saldo en cuenta de ahorros");
                }
        }else{
            throw new AccountNotFoundException("Cuenta no registrada o inactiva");
        }
    }

    public void transferir(TransactionDTO trx){
        //Validar cuenta de origen y cuenta destino
        Account accountOrig = getById(trx.getIdCuentaOrig());
        Account accountDest = getById(trx.getIdCuentaDest());

            if(accountDest == null){
                throw new AccountNotFoundException("Cuenta Destino no registrada");
            }else{
                double saldoOrig = accountOrig.getSaldo();
                double saldoDest = accountDest.getSaldo();
                double montoTransf = trx.getMonto();
                    //Valida que cuenta origen tenga el saldo suficiente
                    if(montoTransf > saldoOrig){
                        throw new AccountAmountException("Saldo Insuficiente");
                    }else{
                        double newSaldoOrig = saldoOrig - montoTransf;
                        accountOrig.setSaldo(newSaldoOrig);
                        accountDao.update(accountOrig);

                        double newSaldoDest = saldoDest + montoTransf;
                        accountDest.setSaldo(newSaldoDest);
                        accountDao.update(accountDest);

                        transactionClient.registerTransferencia(trx);
                    }

            }

    }

    public ArrayList<TransactionDTO> showHistorial(){
        return transactionClient.getAll();
    }

    public void delete(long id) {
        accountDao.delete(id);
    }

    public ArrayList<Account> getAccountByClient(long idClient){
        ArrayList<Account> accounts = accountDao.getByIdClient(idClient);
            if(accounts != null){
                return accounts;
            }else{
                throw new AccountNotFoundException("Cuenta no registrada");
            }
    }
}
