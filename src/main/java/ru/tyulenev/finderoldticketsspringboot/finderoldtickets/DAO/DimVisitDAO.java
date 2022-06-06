package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;

import javax.persistence.PersistenceContext;
import java.util.List;


@PersistenceContext(unitName = "OldTickets")
public interface DimVisitDAO extends CrudRepository<DimVisitEntity, Integer> {

    @Query(value = "SELECT * FROM stat.dim_visit where ticket_id = ?1", nativeQuery = true)
    List<DimVisitEntity> findByTicket_id(String ticket_id);


}
