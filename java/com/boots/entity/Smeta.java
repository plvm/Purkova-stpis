package com.boots.entity;
import javax.persistence.*;

@Entity
@Table(name = "smeta")
public class Smeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private Long numberobjekt;
    private Long numberrabota;
    private Long kolvo;
    private Double pric;
    private Double summa;

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Long getKolvo() {
        return kolvo;
    }

    public void setKolvo(Long kolvo) {
        this.kolvo = kolvo;
    }

    public Double getPric() {
        return pric;
    }

    public void setPric(Double pric) {
        this.pric = pric;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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
}