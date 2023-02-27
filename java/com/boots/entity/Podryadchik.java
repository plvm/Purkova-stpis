package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "podryadchik")
public class Podryadchik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numberpodryadchik;
String name;
String phone;
String email;

    public Long getNumberpodryadchik() {
        return numberpodryadchik;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setNumberpodryadchik(Long numberpodryadchik) {
        this.numberpodryadchik = numberpodryadchik;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
