package com.microservice.account;

import com.microservice.account.client.Client;
import com.microservice.account.dao.AccountDao;
import com.microservice.account.dto.ClientDTO;
import com.microservice.account.model.Account;
import com.microservice.account.service.AccountService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountDao accountDao;

    @Mock
    Client client;

    @InjectMocks
    AccountService accountService;

    Account account = new Account();;
    Account account2 = new Account();;
    ArrayList<Account> accountList = new ArrayList<>();
    ClientDTO clientDTO = new ClientDTO();

    @BeforeEach
    void setUp(){
        account.setId(1);
        account.setIdCliente(1);
        account.setNroCuenta("76655434526");
        account.setTipoCuenta(1);
        account.setSaldo(450);
        account.setStatus(1);

        account2.setId(2);
        account2.setIdCliente(2);
        account2.setNroCuenta("76655434123");
        account2.setTipoCuenta(0);
        account2.setSaldo(500);
        account2.setStatus(1);

        accountList.add(account);
        accountList.add(account2);

        clientDTO.setId(1);
        clientDTO.setDni("67676554");
        clientDTO.setNombres("Joan");
        clientDTO.setApellidos("Asencios");
        clientDTO.setEmail("67676554");
    }

    @Test
    void register(){
        Mockito.when(accountDao.register(account))
                .thenReturn(account);

        Mockito.when(client.getById(clientDTO.getId()))
                .thenReturn(clientDTO);

        final Account accountResult = accountService.register(account);

        Assertions.assertNotNull(accountResult);
        Assertions.assertEquals(account, accountResult);
        Mockito.verify(accountDao, Mockito.times(1)).register(account);
    }

    @Test
    void search(){
        Mockito.when(accountDao.getAll())
                        .thenReturn(accountList);

        final ArrayList<Account> resultList = accountService.getAll();

        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(accountList, resultList);
        Mockito.verify(accountDao, Mockito.times(1)).getAll();
    }

    @Test
    void searchId(){
        Mockito.when(accountDao.getById(account.getId()))
                        .thenReturn(account);

        final Account resultAcc = accountService.getById(account.getId());

        Assertions.assertNotNull(resultAcc);
        Assertions.assertEquals(account, resultAcc);
        Mockito.verify(accountDao, Mockito.times(1)).getById(account.getId());
    }

    @Test
    void delete(){
        Mockito.doNothing().when(accountDao).delete(account.getId());

        accountService.delete(account.getId());
        Mockito.verify(accountDao, Mockito.times(1)).delete(account.getId());
    }

}
