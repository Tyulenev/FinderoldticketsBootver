package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.DimServiceDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.DimVisitDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.FactVisitDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData.ResponseData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ServiceVisitsImpl
{

    @Autowired
    private DimVisitDAO visitDAO;
    @Autowired
    private FactVisitDAO factVisitDAO;
    @Autowired
    private DimServiceDAO dimServiceDAO;

//    @Override
//    @Transactional
    public List<DimVisitEntity> getAllVisits() {
        List<DimVisitEntity> listData = (List<DimVisitEntity>)visitDAO.findAll();
        System.out.println("Service meth getAllVisits:\n");
        return listData;
    }
//

    public List<FactVisitTransactionEntity> getFactVisits() {
        List<FactVisitTransactionEntity> listData = (List<FactVisitTransactionEntity>)factVisitDAO.findAll();
        System.out.println("Service meth getFactVisits:\n");
        return listData;
    }

    public List<DimServiceEntity> getDimServices() {
        List<DimServiceEntity> listData = (List<DimServiceEntity>)dimServiceDAO.findAll();
        System.out.println("Service meth getDimServices:\n");
        return listData;
    }

    public ResponseData getResponce(String ticketId, String dateReq) {
        ResponseData responseData = new ResponseData();
        responseData.setTicket_id(ticketId);
        responseData.setDate(dateReq);

        List<DimVisitEntity>  listDimVisit = getAllVisits();
        List<FactVisitTransactionEntity> listFactVisit = getFactVisits();
        List<DimServiceEntity> listDimService = getDimServices();

        //Try find visit
        DimVisitEntity findedDimVisit = null;
        for (DimVisitEntity dimVisit:listDimVisit) {
            if ((checkDates(dateReq, dimVisit.getCreated_timestamp())) &&
            ticketId.equals(dimVisit.getTicket_id()))
            {
                findedDimVisit = dimVisit;
                System.out.println("dimVisit - " + dimVisit);
                System.out.println("findedDimVisit - " + findedDimVisit);
                break;
            }
        }

        if (findedDimVisit == null) {
            responseData.setComment("none");
            return responseData;
        } else {
            responseData.setComment("OK");
            responseData.setCustom_1(findedDimVisit.getCustom_1());
            responseData.setCustom_2(findedDimVisit.getCustom_2());
            responseData.setCustom_3(findedDimVisit.getCustom_3());
            responseData.setCustom_4(findedDimVisit.getCustom_4());
            responseData.setCustom_5(findedDimVisit.getCustom_5());
//           Work with fact_visit table
            for (FactVisitTransactionEntity factVisitTrans : listFactVisit) {
                if (factVisitTrans.getVisit_key() == findedDimVisit.getOrigin_id()) {
                    for (DimServiceEntity dimService:listDimService) {
                        if (factVisitTrans.getService_key() == dimService.getId()) {
                            responseData.addOrigin_ids(dimService.getOrigin_id());
                        }
                    }
                }
            }
        }


        return responseData;
    }

    private boolean checkDates(String dateString, Long timeLong1) {
        boolean res = false;
        List<SimpleDateFormat> formatter = new ArrayList<>();
        formatter.add(new SimpleDateFormat("ddMMyyyy"));
        formatter.add(new SimpleDateFormat("dd-MM-yyyy"));
        formatter.add(new SimpleDateFormat("dd/MM/yyyy"));
//        formatter.add(new SimpleDateFormat("dd.MM.yyyy"));
        formatter.add(new SimpleDateFormat("yyyy-MM-dd"));
        formatter.add(new SimpleDateFormat("yyyy/MM/dd"));
//        formatter.add(new SimpleDateFormat("yyyy.MM.dd"));
        formatter.add(new SimpleDateFormat("dd-MM-yy"));
        formatter.add(new SimpleDateFormat("dd/MM/yy"));
//        formatter.add(new SimpleDateFormat("dd.MM.yy"));
        formatter.add(new SimpleDateFormat("yy-MM-dd"));
        formatter.add(new SimpleDateFormat("yy/MM/dd"));
//        formatter.add(new SimpleDateFormat("yy.MM.dd"));

        Date date = new Date(timeLong1);
        for (SimpleDateFormat sf:formatter) {
            String dateLongToString = sf.format(date);
            if (dateLongToString.equals(dateString)) {
                res = true;
                break;
            }
        }
        return res;
    }

}
