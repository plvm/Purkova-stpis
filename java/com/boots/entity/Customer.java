package com.boots.entity;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numbercustomer;
    private String name;
    private String email;

    private String address;

    public Customer() {
    }

    public Customer(Long numbercustomer, String name, String email, String address) {
        this.numbercustomer = numbercustomer;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getNumbercustomer() {
        return numbercustomer;
    }

    public void setNumbercustomer(Long numbercustomer) {
        this.numbercustomer = numbercustomer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}