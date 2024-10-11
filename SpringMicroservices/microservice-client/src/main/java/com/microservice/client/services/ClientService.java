package com.microservice.client.services;

import com.microservice.client.AccountClient.AccountClient;
import com.microservice.client.dao.ClientDao;
import com.microservice.client.dto.AccountDTO;
import com.microservice.client.model.Client;
import com.microservice.client.util.exceptions.DeleteClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDao clientDao;

    @Autowired
    AccountClient accountClient;

    public Client register(Client client){
        return clientDao.register(client);
    }

    public Client getById(long id){
        return clientDao.getById(id);
    }

    public ArrayList<Client> getAll(){
        return clientDao.getAll();
    }

    public Client update(Client client){
        return clientDao.update(client);
    }

    public void delete(long id){
        //Validar si tiene cuentas activas
        ArrayList<AccountDTO> accounts = accountClient.getAccountByClient(id);
            if(accounts.stream().anyMatch(account ->
                    account.getStatus() == 1)){
                throw new DeleteClientException("No se puede eliminar cliente con cuentas activas");
            }else{
                clientDao.delete(id);//Tambien debe eliminarse sus cuentas
            }
    }

}
