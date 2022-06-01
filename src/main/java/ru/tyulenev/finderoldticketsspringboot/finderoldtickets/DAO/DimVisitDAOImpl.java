package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DimVisitDAOImpl     implements DimVisitDAO
{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DimVisitEntity> getAllData() {
        Session session = entityManager.unwrap(Session.class);

        List<DimVisitEntity> allVisits =
                session.createQuery("from DimVisitEntity").list();

        for (DimVisitEntity de:allVisits) {
            System.out.println(de);
        }
        return allVisits;
    }

}
