package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;



import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;

import java.util.List;

public interface FactVisitDAO {
    public List<FactVisitTransactionEntity> getAllData();
}
