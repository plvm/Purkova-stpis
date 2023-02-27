package com.boots.entity;
import javax.persistence.*;

@Entity
@Table(name = "objekt")
public class Objekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberobjekt;
    private Long numberpodryadchik;
    private Long numbercustomer;

    private String info;

    public Long getNumbercustomer() {
        return numbercustomer;
    }

    public void setNumbercustomer(Long numbercustomer) {
        this.numbercustomer = numbercustomer;
    }

    public void setNumberobjekt(Long numberobjekt) {
        this.numberobjekt = numberobjekt;
    }

    public void setNumberpodryadchik(Long numberpodryadchik) {
        this.numberpodryadchik = numberpodryadchik;
    }

    public void setInfo(String address) {
        this.info = address;
    }

    public Long getNumberobjekt() {
        return numberobjekt;
    }

    public Long getNumberpodryadchik() {
        return numberpodryadchik;
    }

    public String getInfo() {
        return info;
    }
}