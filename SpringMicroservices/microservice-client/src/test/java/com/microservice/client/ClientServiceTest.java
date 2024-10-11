package com.microservice.client;

import com.microservice.client.AccountClient.AccountClient;
import com.microservice.client.controller.ClientController;
import com.microservice.client.dao.ClientDao;
import com.microservice.client.model.Client;
import com.microservice.client.services.ClientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientServiceTest {


    @Autowired
    ClientController clientController;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientDao clientDao;

    Client client;


    @BeforeAll
    void init(){
        client = new Client();
        client.setId(10);
        client.setNombres("Pau");
        client.setApellidos("Victor");
        client.setDni("76677665");
        client.setEmail("pvictor@nttdata.com");

    }

    @Test
    void register(){
        clientController.register(client);
    }

    @Test
    void searchId(){
        clientController.getById(client.getId());
    }

    @Test
    void search(){
        clientController.getAll();
    }

    @Test
    void update(){
        clientController.update(client);
    }

    @Test
    void delete(){
        clientController.delete(client.getId());
    }

}
