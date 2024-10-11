package com.microservice.client.AccountClient;

import com.microservice.client.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(name = "msvc-account", url = "localhost:9090/api/account")
public interface AccountClient {

    @GetMapping("/search-by-client/{idClient}")
    ArrayList<AccountDTO> getAccountByClient(@PathVariable long idClient);

}
