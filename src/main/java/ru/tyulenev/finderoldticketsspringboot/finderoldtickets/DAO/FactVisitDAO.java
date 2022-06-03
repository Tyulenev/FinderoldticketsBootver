package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;



import org.springframework.data.repository.CrudRepository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;
//import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;

import javax.persistence.PersistenceContext;
import java.util.List;

@PersistenceContext(unitName = "OldTickets")
public interface FactVisitDAO extends CrudRepository<FactVisitTransactionEntity, Integer> {
}
