package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.RestData;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {
    private String ticket_id;
    private String date;
    private String comment;
    private String custom_1;
    private String custom_2;
    private String custom_3;
    private String custom_4;
    private String custom_5;
    private List<Long> origin_ids;

    public ResponseData() {
        origin_ids = new ArrayList<Long>();
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustom_1() {
        return custom_1;
    }

    public void setCustom_1(String custom_1) {
        this.custom_1 = custom_1;
    }

    public String getCustom_2() {
        return custom_2;
    }

    public void setCustom_2(String custom_2) {
        this.custom_2 = custom_2;
    }

    public String getCustom_3() {
        return custom_3;
    }

    public void setCustom_3(String custom_3) {
        this.custom_3 = custom_3;
    }

    public String getCustom_4() {
        return custom_4;
    }

    public void setCustom_4(String custom_4) {
        this.custom_4 = custom_4;
    }

    public String getCustom_5() {
        return custom_5;
    }

    public void setCustom_5(String custom_5) {
        this.custom_5 = custom_5;
    }

    public List<Long> getOrigin_ids() {
        return origin_ids;
    }

    public void setOrigin_ids(List<Long> origin_ids) {
        this.origin_ids = origin_ids;
    }

    public void addOrigin_ids(Long originIdAdded) {
        this.origin_ids.add(originIdAdded);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "ticket_id='" + ticket_id + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", custom_1='" + custom_1 + '\'' +
                ", custom_2='" + custom_2 + '\'' +
                ", custom_3='" + custom_3 + '\'' +
                ", custom_4='" + custom_4 + '\'' +
                ", custom_5='" + custom_5 + '\'' +
                ", origin_ids=" + origin_ids +
                '}';
    }
}
