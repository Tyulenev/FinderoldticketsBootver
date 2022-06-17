package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.DimServiceDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.DimVisitDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.DAO.FactVisitDAO;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData.ResponseData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//+++++++++++++++++++++++++
//NOT USED IN LAST VER
//+++++++++++++++++++++++++

@Service
public class ServiceVisitsImpl
{

    @Autowired
    private DimVisitDAO visitDAO;
    @Autowired
    private FactVisitDAO factVisitDAO;
    @Autowired
    private DimServiceDAO dimServiceDAO;

    @Value("${ticket.CountOfHoursforFindTickets}")
    private int CountOfHoursforFindTickets;


//    @Override
//    @Transactional
    private List<DimVisitEntity> getAllVisits() {
        List<DimVisitEntity> listData = (List<DimVisitEntity>)visitDAO.findAll();
        return listData;
    }
//


    private List<FactVisitTransactionEntity> getFactVisits() {
        List<FactVisitTransactionEntity> listData = (List<FactVisitTransactionEntity>)factVisitDAO.findAll();
        return listData;
    }

    private List<DimServiceEntity> getDimServices() {
        List<DimServiceEntity> listData = (List<DimServiceEntity>)dimServiceDAO.findAll();
        return listData;
    }

    public List<DimVisitEntity> getTicketsById(String tId) {
        List<DimVisitEntity> listData = visitDAO.findByTicket_id(tId);
        return listData;
    }


//    public ResponseData getResponce(String ticketId, String dateReq) {
//        ResponseData responseData = new ResponseData();
//        responseData.setTicket_id(ticketId);
//        responseData.setDate(dateReq);
//
//        List<DimVisitEntity>  listDimVisit = (List<DimVisitEntity>)visitDAO.findByTicket_id(ticketId);
//        List<DimServiceEntity> listDimService = getDimServices();
//
//        //Try find visit
//        DimVisitEntity findedDimVisit = null;
//        for (DimVisitEntity dimVisit:listDimVisit) {
//            if ((checkDates(dateReq, dimVisit.getCreated_timestamp())) &&
//            ticketId.equals(dimVisit.getTicket_id()))
//            {
//                findedDimVisit = dimVisit;
////                System.out.println("dimVisit - " + dimVisit);
////                System.out.println("findedDimVisit - " + findedDimVisit);
//                break;
//            }
//        }
//        if (findedDimVisit == null) {
//            responseData.setComment("none");
//            return responseData;
//        } else {
//            responseData.setComment("OK");
//            responseData.setCustom_1(findedDimVisit.getCustom_1());
//            responseData.setCustom_2(findedDimVisit.getCustom_2());
//            responseData.setCustom_3(findedDimVisit.getCustom_3());
//            responseData.setCustom_4(findedDimVisit.getCustom_4());
//            responseData.setCustom_5(findedDimVisit.getCustom_5());
//
//            //Get data from fact_visit_transaction table
//            List<FactVisitTransactionEntity> listFactVisit = factVisitDAO
//                    .findFactVisitByVisitKey(findedDimVisit.getOrigin_id());
//
//            //           Work with fact_visit table
//            for (FactVisitTransactionEntity factVisitTrans : listFactVisit) {
//                System.out.println(factVisitTrans);
//                for (DimServiceEntity dimService : listDimService) {
//                    if (factVisitTrans.getService_key() == dimService.getId()) {
//                        responseData.addOrigin_ids(dimService.getOrigin_id());
//                    }
//                }
//            }
//        }
//        return responseData;
//    }

    public ResponseData getResponceByTresholdValues(String ticketId, String dateReq) {
        ResponseData responseData = new ResponseData();
        responseData.setTicket_id(ticketId);
        responseData.setDate(dateReq);

//        List<DimVisitEntity>  listDimVisit = (List<DimVisitEntity>)visitDAO.findByTicket_id(ticketId);
        Long[] longValues;
        longValues = StringToLongDate(dateReq);
        List<DimVisitEntity>  listDimVisit = (List<DimVisitEntity>)visitDAO
                .findByTicket_id_and_LongTimeMinMax(ticketId, longValues[0], longValues[1]);
        List<DimServiceEntity> listDimService = getDimServices();

        //Try find visit
        DimVisitEntity findedDimVisit = null;
        for (DimVisitEntity dimVisit:listDimVisit) {
            if ((checkDates(dateReq, dimVisit.getCreated_timestamp())) &&
                    ticketId.equals(dimVisit.getTicket_id()))
            {
                findedDimVisit = dimVisit;
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

            //Get data from fact_visit_transaction table
            List<FactVisitTransactionEntity> listFactVisit = factVisitDAO
                    .findFactVisitByVisitKey(findedDimVisit.getOrigin_id());

            //           Work with fact_visit table
            for (FactVisitTransactionEntity factVisitTrans : listFactVisit) {
                System.out.println(factVisitTrans);
                for (DimServiceEntity dimService : listDimService) {
                    if (factVisitTrans.getService_key() == dimService.getId()) {
//                        responseData.addOrigin_ids(dimService.getOrigin_id());
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
        formatter.add(new SimpleDateFormat("yyyyMMdd"));
        formatter.add(new SimpleDateFormat("dd-MM-yyyy"));
        formatter.add(new SimpleDateFormat("yyyy-MM-dd"));
        formatter.add(new SimpleDateFormat("dd-MM-yy"));
        formatter.add(new SimpleDateFormat("yy-MM-dd"));

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

    private Long[] StringToLongDate(String dateIn)   //[0] - min, [1] - max
    {
        Long returnVal[] = new Long[2];

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getDefault());
        try {
            cal.setTime(sdf.parse(dateIn));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - CountOfHoursforFindTickets);
        returnVal[0] = cal.getTimeInMillis();
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 24+ 2*CountOfHoursforFindTickets);
        returnVal[1] = cal.getTimeInMillis();
//        System.out.println("CountOfHoursforFindTickets = " + CountOfHoursforFindTickets);
//        System.out.println("returnVal[0] = " + returnVal[0] + ", returnVal[1] = " + returnVal[1]);
        return returnVal;
    }

}
