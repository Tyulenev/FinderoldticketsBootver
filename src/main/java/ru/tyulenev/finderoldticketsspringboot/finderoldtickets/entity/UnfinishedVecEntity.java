package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.unfinished_VEC")
public class UnfinishedVecEntity {
    private String ticket_id;
    private Long branch_id;
    @Id
    private Long visit_id;
    private Long created_timestamp;
    private String services_origin_id;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String custom5;

    public UnfinishedVecEntity() {
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Long branch_id) {
        this.branch_id = branch_id;
    }

    public Long getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Long visit_id) {
        this.visit_id = visit_id;
    }

    public Long getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Long created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public String getServices_origin_id() {
        return services_origin_id;
    }

    public void setServices_origin_id(String services_origin_id) {
        this.services_origin_id = services_origin_id;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    @Override
    public String toString() {
        return "UnfinishedVecEntity{" +
                "ticket_id='" + ticket_id + '\'' +
                ", branch_id=" + branch_id +
                ", visit_id=" + visit_id +
                ", created_timestamp=" + created_timestamp +
                ", services_origin_id='" + services_origin_id + '\'' +
                ", custom1='" + custom1 + '\'' +
                ", custom2='" + custom2 + '\'' +
                ", custom3='" + custom3 + '\'' +
                ", custom4='" + custom4 + '\'' +
                ", custom5='" + custom5 + '\'' +
                '}';
    }
}
