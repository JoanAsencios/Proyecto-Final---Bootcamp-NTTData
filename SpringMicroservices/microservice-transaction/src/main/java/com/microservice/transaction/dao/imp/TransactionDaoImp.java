package com.microservice.transaction.dao.imp;

import com.microservice.transaction.dao.TransactionDao;
import com.microservice.transaction.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public class TransactionDaoImp implements TransactionDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registerDeposito(Transaction trx) {
        entityManager.persist(trx);
    }

    @Override
    public void registerRetiro(Transaction trx) {
        entityManager.persist(trx);
    }

    @Override
    public void registerTransferencia(Transaction trx) {
        entityManager.persist(trx);
    }

    @Override
    public ArrayList<Transaction> getAll() {
        String hql = "FROM Transaction as t";
        return (ArrayList<Transaction>) entityManager.createQuery(hql).getResultList();
    }
}
