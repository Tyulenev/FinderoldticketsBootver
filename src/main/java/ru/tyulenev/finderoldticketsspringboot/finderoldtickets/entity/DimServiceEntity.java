package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "stat.dim_service")
@Table(name = "dim_service")
public class DimServiceEntity {

    @Id
    private Long id;
    private Long client_key;
//    private Long branch_origin_id;
    private Long origin_id;
    private String name;
//            transaction_time_sl
//            start_date
//            end_date
//            rpt_name


    public DimServiceEntity() {
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

    public Long getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(Long origin_id) {
        this.origin_id = origin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DimServiceEntity{" +
                "id=" + id +
                ", client_key=" + client_key +
                ", origin_id=" + origin_id +
                ", name='" + name + '\'' +
                '}';
    }
}
