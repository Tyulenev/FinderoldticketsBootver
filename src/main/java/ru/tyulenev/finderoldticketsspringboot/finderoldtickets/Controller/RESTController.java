package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Exceptions.TicketNotFoundException;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData.ResponseData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Service.ServiceUnfinishedData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.UnfinishedVecEntity;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

//    @Autowired
//    private ServiceVisitsImpl dimVisitService;

    @Autowired
    private ServiceUnfinishedData serviceUnfinishedData;



    @GetMapping("/test1")
    public ResponseData test1() {
//    public String test1() {
        ResponseData resData = new ResponseData();
        resData.setCustom_1("Custom1");
        resData.setCustom_2("Custom2");
        resData.setCustom_3("Custom3");
        resData.setCustom_4("Custom4");
        resData.setCustom_5("Custom5");
        resData.setTicket_id("A007");
        List<Long> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add(3L);
        list1.add(6L);
//        resData.setOrigin_ids(list1);
        return resData;
    }

    @GetMapping("/getInfo/tickets")
    public List<UnfinishedVecEntity> getAllData() {
        List<UnfinishedVecEntity> responseData= serviceUnfinishedData.getAllData();
        return responseData;
    }

    @GetMapping("/getInfo/ticket/{id}/date/{date}")
    public ResponseData getDataByDateAndId2(@PathVariable String id,
                                           @PathVariable String date) {
        ResponseData responseData = serviceUnfinishedData.getResponceByTresholdValues(id, date);
        if (responseData.getComment().equals("none")) {
            throw new TicketNotFoundException("There is no ticket with number " + id + " from " + responseData.getDate());
        }
        return responseData;
    }


}