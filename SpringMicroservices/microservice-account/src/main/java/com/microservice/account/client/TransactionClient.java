package com.microservice.account.client;

import com.microservice.account.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@FeignClient(name = "msvc-transaction", url = "localhost:9091/api/transaction")
public interface TransactionClient {

    @PostMapping("/register/deposito")
    void registerDeposito(@RequestBody TransactionDTO trx);

    @PostMapping("/register/retiro")
    void registerRetiro(@RequestBody TransactionDTO trx);

    @PostMapping("/register/trasferencia")
    void registerTransferencia(@RequestBody TransactionDTO trx);

    @GetMapping("/search/historial")
    ArrayList<TransactionDTO> getAll();
}
