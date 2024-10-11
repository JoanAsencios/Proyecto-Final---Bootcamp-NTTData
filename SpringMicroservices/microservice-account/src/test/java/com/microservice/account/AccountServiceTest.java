package com.microservice.account;

import com.microservice.account.model.Account;
import com.microservice.account.service.AccountService;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceTest {

    AccountService accountService;
    Account account;

    @BeforeAll
    void init(){
        account = new Account();
        account.setId(1);
        account.setIdCliente(1);
        account.setNroCuenta("76655434526");
        account.setTipoCuenta(1);
        account.setSaldo(450);
        account.setStatus(1);

        accountService = new AccountService();
    }

    @Test
    void register(){
        init();
        accountService.register(account);
    }

    @Test
    void search(){
        init();
        accountService.register(account);
    }

    @Test
    void searchId(){
        init();
        accountService.register(account);
    }

    @Test
    void depositar(){
        init();
        accountService.register(account);
    }

    @Test
    void retirar(){
        init();
        accountService.register(account);
    }

    @Test
    void transferir(){
        init();
        accountService.register(account);
    }

    @Test
    void historial(){
        init();
        accountService.register(account);
    }

    @Test
    void delete(){
        init();
        accountService.register(account);
    }

    @Test
    void getAccountByClient(){
        init();
        accountService.register(account);
    }


}
