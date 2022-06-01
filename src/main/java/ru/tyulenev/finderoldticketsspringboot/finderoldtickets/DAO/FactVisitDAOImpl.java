package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FactVisitDAOImpl implements FactVisitDAO
{
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<FactVisitTransactionEntity> getAllData() {
        Session session = entityManager.unwrap(Session.class);

        List<FactVisitTransactionEntity> factVisit =
                session.createQuery("from FactVisitTransactionEntity").list();

        return factVisit;
    }
}
