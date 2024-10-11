package com.microservice.account.dao;

import com.microservice.account.model.Account;

import java.util.ArrayList;

public interface AccountDao {

    Account register(Account account);
    ArrayList<Account> getAll();
    Account getById(long id);
    ArrayList<Account> getByIdClient(long idCliente);
    Account update(Account account);
    void delete(long id);

}
