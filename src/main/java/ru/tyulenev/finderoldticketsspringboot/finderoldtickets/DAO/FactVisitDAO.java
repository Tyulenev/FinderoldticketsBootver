package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;
//import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;

import javax.persistence.PersistenceContext;
import java.util.List;

@PersistenceContext(unitName = "OldTickets")
public interface FactVisitDAO extends CrudRepository<FactVisitTransactionEntity, Integer> {
    @Query(value = "SELECT * FROM stat.fact_visit_transaction where visit_key = ?1", nativeQuery = true)
    List<FactVisitTransactionEntity> findFactVisitByVisitKey(Long visitKey);
}
