package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Exceptions.TicketIncorrectData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Exceptions.TicketNotFoundException;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData.ResponseData;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Service.ServiceVisitsImpl;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimServiceEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.DimVisitEntity;
import ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity.FactVisitTransactionEntity;


import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private ServiceVisitsImpl dimVisitService;
//
    @GetMapping("/all_visits")
    public List<DimVisitEntity> showAllVisits() {
        List<DimVisitEntity> allVisits = dimVisitService.getAllVisits();
        return allVisits;
    }
//
    @GetMapping("/fact_visits")
    public List<FactVisitTransactionEntity> showfactVisits() {
        List<FactVisitTransactionEntity> factVisits = dimVisitService.getFactVisits();
        return factVisits;
    }

    @GetMapping("/dim_services")
    public List<DimServiceEntity> showDimServices() {
        List<DimServiceEntity> factVisits = dimVisitService.getDimServices();
        return factVisits;
    }

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
        resData.setOrigin_ids(list1);
        return resData;
    }

//    @GetMapping("/test2")
//    public String test2() {
//        String str= "Test2. test!";
//        System.out.println("Method 'test2'");
//        return str;
//    }
//
//    @GetMapping("/test3")
//    public String test3() {
//
////        Map<String,String> map = new HashMap<>();
////        map.put("custom1", "C1");
////        map.put("custom2", "C2");
////        map.put("custom3", "C3");
////        map.put("custom3", "C3");
////        map.put("custom4", "C5");
////        map.put("ticket_id", "A003");
//        ResponseData resData = new ResponseData();
//        resData.setCustom_1("Custom1 something written here");
//        resData.setCustom_2("Custom2 asdsfds");
//        resData.setCustom_3("Custom3 fdsfds");
//        resData.setCustom_4("Custom4 dfsfds");
//        resData.setCustom_5("Custom5 dffsds");
//        resData.setTicket_id("A007");
//        List<Long> list1 = new ArrayList<>();
//        list1.add(1L);
//        list1.add(3L);
//        list1.add(6L);
//        resData.setOrigin_ids(list1);
//
////        Map<String, String> data = new HashMap();
//        String restData = (new Gson()).toJson(resData);
////        data.put("data", restData);
//
//        return restData;
//    }

    @GetMapping("/getInfo/ticket/{id}/date/{date}")

    public ResponseData getDataByDateAndId(@PathVariable String id,
                                           @PathVariable String date) {
        ResponseData responseData = dimVisitService.getResponce(id, date);
        if (responseData.getComment().equals("none")) {
            throw new TicketNotFoundException("There is no ticket with specified " +
                    "data (number - " + id +
                    ", date - " + responseData.getDate() + ")");
        }
        return responseData;
    }


}
