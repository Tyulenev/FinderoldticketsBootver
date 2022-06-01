package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DimServiceDAOImpl   implements DimServiceDAO
{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DimServiceEntity> getAllData() {
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityManager.unwrap(Session.class);


        List<DimServiceEntity> factVisit =
                session.createQuery("from DimServiceEntity").list();
        return factVisit;
    }
}
