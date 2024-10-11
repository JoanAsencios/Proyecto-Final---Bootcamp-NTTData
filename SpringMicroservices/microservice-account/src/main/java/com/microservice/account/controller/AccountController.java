package com.microservice.account.controller;

import com.microservice.account.dto.TransactionDTO;
import com.microservice.account.model.Account;
import com.microservice.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return accountService.register(account);
    }

    @GetMapping("/search")
    public ArrayList<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/search/{id}")
    public Account getById(@PathVariable long id){
        return accountService.getById(id);
    }

    @PutMapping("/depositar")
    public void depositar(@RequestBody TransactionDTO trx){
         accountService.depositar(trx);
    }

    @PutMapping("/retirar")
    public void retirar(@RequestBody TransactionDTO trx){
         accountService.retirar(trx);
    }

    @PutMapping("/transferir")
    public void transferir(@RequestBody TransactionDTO trx){
         accountService.transferir(trx);
    }

    @GetMapping("/historial")
    public ArrayList<TransactionDTO> showHistorial(){
        return accountService.showHistorial();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
         accountService.delete(id);
    }

    @GetMapping("/search-by-client/{idClient}")
    public ArrayList<Account> getAccountByClient(@PathVariable long idClient){
        return accountService.getAccountByClient(idClient);
    }

}
