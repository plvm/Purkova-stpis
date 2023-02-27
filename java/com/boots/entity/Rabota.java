package com.boots.entity;
import javax.persistence.*;

@Entity
@Table(name = "rabota")
public class Rabota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberrabota;
    private String unit;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getNumberrabota() {
        return numberrabota;
    }

    public void setNumberrabota(Long numberrabota) {
        this.numberrabota = numberrabota;
    }
}