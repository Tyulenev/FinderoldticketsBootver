package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table (name = "stat.dim_visit")
@Table (name = "stat.dim_visit")
public class DimVisitEntity {
    @Id
    private Integer id;
//    private Integer client_key;
//    private Integer branch_origin_id;
    private Long origin_id;
//    private String vip_level;
    private String ticket_id;
    private Long created_timestamp;
//    private Integer appointment_id;
//    private Integer gender_key;
//    private Integer language_key;
//    private Integer channel_key;
    private String custom_1;
    private String custom_2;
    private String custom_3;
    private String custom_4;
    private String custom_5;

    public DimVisitEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(Long origin_id) {
        this.origin_id = origin_id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Long getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(Long created_timestamp) {
        this.created_timestamp = created_timestamp;
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

    @Override
    public String toString() {
        return "DimVisitEntity{" +
                "id=" + id +
                ", origin_id=" + origin_id +
                ", ticket_id='" + ticket_id + '\'' +
                ", created_timestamp=" + created_timestamp +
                ", custom_1='" + custom_1 + '\'' +
                ", custom_2='" + custom_2 + '\'' +
                ", custom_3='" + custom_3 + '\'' +
                ", custom_4='" + custom_4 + '\'' +
                ", custom_5='" + custom_5 + '\'' +
                '}';
    }
}
