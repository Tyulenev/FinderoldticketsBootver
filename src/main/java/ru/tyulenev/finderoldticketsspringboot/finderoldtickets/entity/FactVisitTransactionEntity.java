package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "stat.fact_visit_transaction")
@Table(name = "stat.fact_visit_transaction")
public class FactVisitTransactionEntity {

    @Id
    private Long id;

    private Long client_key;
//    private int branch_key;
    private Long date_key;
//    private int time_key;
//    private int time_seconds;
    private Long visit_key;
//    private int visit_outcome_key;
    private Long service_key;
//    private int queue_key;
//    private int queue_typ_key;
//    private int entry_point_key;
//    private int service_point_key;
//    private int staff_key;
//    private int work_profile_key;
//    private int outcome_key;
//    private int vertical_message_key;
//    private int waiting_time;
//    private int transaction_time;
//    private int staff_transaction_time;
//    private int walking_time;
//    private int wrapup_time;
//    private int queue_wt_lvl;
//    private int service_trt_lvl;
//    private int branch_origin_id;
//    private int visit_transaction_id;
//    private int service_point_transaction_id;
//    private int staff_transaction_id;
//    private int appointment_id;
//    private int visit_call_type_key;
//    private int create_timestamp;
//    private int call_timestamp;
//    private int recycle_count;


    public FactVisitTransactionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_key() {
        return client_key;
    }

    public void setClient_key(Long client_key) {
        this.client_key = client_key;
    }

    public Long getDate_key() {
        return date_key;
    }

    public void setDate_key(Long date_key) {
        this.date_key = date_key;
    }

    public Long getVisit_key() {
        return visit_key;
    }

    public void setVisit_key(Long visit_key) {
        this.visit_key = visit_key;
    }

    public Long getService_key() {
        return service_key;
    }

    public void setService_key(Long service_key) {
        this.service_key = service_key;
    }

    @Override
    public String toString() {
        return "FactVisitTransactionEntity{" +
                "id=" + id +
                ", client_key=" + client_key +
                ", date_key=" + date_key +
                ", visit_key=" + visit_key +
                ", service_key=" + service_key +
                '}';
    }
}
