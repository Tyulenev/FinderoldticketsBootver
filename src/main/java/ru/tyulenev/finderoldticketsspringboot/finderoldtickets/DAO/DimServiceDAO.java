package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO;

;

import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;

import java.util.List;

public interface DimServiceDAO {
    public List<DimServiceEntity> getAllData();
}
