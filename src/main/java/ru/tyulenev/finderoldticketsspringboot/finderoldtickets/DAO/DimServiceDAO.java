package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

;

import org.springframework.data.repository.CrudRepository;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;

import javax.persistence.PersistenceContext;
import java.util.List;

@PersistenceContext(unitName = "OldTickets")
public interface DimServiceDAO extends CrudRepository<DimServiceEntity, Integer> {
}
