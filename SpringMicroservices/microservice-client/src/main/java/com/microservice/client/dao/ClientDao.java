package com.microservice.client.dao;

import com.microservice.client.model.Client;
import java.util.ArrayList;

public interface ClientDao {

    Client register(Client client);
    ArrayList<Client> getAll();
    Client getById(long id);
    Client update(Client client);
    void delete(long id);
}
