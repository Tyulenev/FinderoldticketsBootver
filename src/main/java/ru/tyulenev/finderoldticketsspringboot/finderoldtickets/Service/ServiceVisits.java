package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Service;



import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData.ResponseData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;

import java.util.List;

public interface ServiceVisits {
    public List<DimVisitEntity> getAllVisits();
    public List<FactVisitTransactionEntity> getFactVisits();
    public List<DimServiceEntity> getDimServices();
    public ResponseData getResponce(String ticketId, String dateReq);
}
