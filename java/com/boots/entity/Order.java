package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderr")
public class Order {
    @Id

    private String id;

    private Long numbercustomer;

    public void setId(String id) {
        this.id = id;
    }

    public void setNumbercustomer(Long numbercustomer) {
        this.numbercustomer = numbercustomer;
    }

    public String getId() {
        return id;
    }

    public Long getNumbercustomer() {
        return numbercustomer;
    }
}
