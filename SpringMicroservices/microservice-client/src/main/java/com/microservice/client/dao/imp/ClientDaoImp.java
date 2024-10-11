package com.microservice.client.dao.imp;

import com.microservice.client.dao.ClientDao;
import com.microservice.client.model.Client;
import com.microservice.client.util.EmailValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Repository
public class ClientDaoImp implements ClientDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Client register(Client client) {
        EmailValidator.emValidator(client.getEmail());
        entityManager.persist(client);
        return client;
    }

    @Override
    public ArrayList<Client> getAll() {
        String hql = "FROM Client as c";
        return (ArrayList<Client>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Client getById(long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public Client update(Client client) {
        entityManager.merge(client);
        return client;
    }

    @Override
    public void delete(long id) {
        Client client = getById(id);
        entityManager.remove(client);
    }

}
