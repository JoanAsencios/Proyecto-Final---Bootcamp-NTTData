package com.microservice.client.controller;

import com.microservice.client.model.Client;
import com.microservice.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    public Client register(@RequestBody Client client){
        return clientService.register(client);
    }

    @GetMapping("/search/{id}")
    public Client getById(@PathVariable long id){
        return clientService.getById(id);
    }

    @GetMapping("/search")
    public ArrayList<Client> getAll(){
        return clientService.getAll();
    }

    @PutMapping("/update")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        clientService.delete(id);
    }
}
