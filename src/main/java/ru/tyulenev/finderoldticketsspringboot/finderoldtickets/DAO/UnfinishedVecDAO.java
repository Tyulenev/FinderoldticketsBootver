package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.UnfinishedVecEntity;

import javax.persistence.PersistenceContext;

;import java.util.List;

@PersistenceContext(unitName = "OldTickets")
public interface UnfinishedVecDAO extends CrudRepository<UnfinishedVecEntity, Integer> {
    @Query(value = "SELECT * FROM dbo.unfinished_VEC WHERE ticket_id = ?1 AND created_timestamp>?2 AND created_timestamp<?3", nativeQuery = true)
    List<UnfinishedVecEntity> findByTicket_id_and_LongTimeMinMax(String ticket_id, Long timeLongMin, Long timeLongMax);

    @Query(value = "SELECT * FROM dbo.unfinished_VEC where ticket_id = ?1", nativeQuery = true)
    List<UnfinishedVecEntity> findByTicket_id(String ticket_id);

//    List deleteByVisit_id(Long visit_id);
}
