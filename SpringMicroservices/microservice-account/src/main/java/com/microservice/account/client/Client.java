package com.microservice.account.client;

import com.microservice.account.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-client", url = "localhost:8090/api/client")
public interface Client {

    @GetMapping("/search/{id}")
    ClientDTO getById(@PathVariable long id);
}
