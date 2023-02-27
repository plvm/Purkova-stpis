package com.boots.entity;
import javax.persistence.*;

@Entity
@Table(name = "kontrol")
public class Kontrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberkontrol;
    private Long numberobjekt;
    private Long numberrabota;
    private Long kolvo;
private Long kolvoost;
    private Double price;
    private String date;
    private Double summa;

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Long getKolvoost() {
        return kolvoost;
    }

    public void setKolvoost(Long kolvoost) {
        this.kolvoost = kolvoost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }




    public Long getNumberkontrol() {
        return numberkontrol;
    }

    public void setNumberkontrol(Long numberkontrol) {
        this.numberkontrol = numberkontrol;
    }

    public Long getNumberobjekt() {
        return numberobjekt;
    }

    public void setNumberobjekt(Long numberobjekt) {
        this.numberobjekt = numberobjekt;
    }

    public Long getNumberrabota() {
        return numberrabota;
    }

    public void setNumberrabota(Long numberrabota) {
        this.numberrabota = numberrabota;
    }

    public Long getKolvo() {
        return kolvo;
    }

    public void setKolvo(Long kolvo) {
        this.kolvo = kolvo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}