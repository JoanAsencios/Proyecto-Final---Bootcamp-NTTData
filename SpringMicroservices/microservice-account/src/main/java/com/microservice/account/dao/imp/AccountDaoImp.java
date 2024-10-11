package com.microservice.account.dao.imp;

import com.microservice.account.dao.AccountDao;
import com.microservice.account.model.Account;
import com.microservice.account.util.AccountNumberGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public class AccountDaoImp implements AccountDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Account register(Account account) {
        account.setNroCuenta(AccountNumberGenerator.numberGen());
        entityManager.persist(account);
        return account;
    }

    @Override
    public ArrayList<Account> getAll() {
        String hql = "FROM Account as a";
        return (ArrayList<Account>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Account getById(long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public ArrayList<Account> getByIdClient(long idClient) {
        String hql = "FROM Account as a WHERE idCliente = " + idClient;
        return (ArrayList<Account>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Account update(Account account) {
        entityManager.merge(account);
        return account;
    }

    @Override
    public void delete(long id) {
        Account account = getById(id);
        entityManager.remove(account);
    }

}
