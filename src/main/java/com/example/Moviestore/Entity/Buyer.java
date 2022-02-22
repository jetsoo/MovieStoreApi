package com.example.Moviestore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "BUYER")
public class Buyer {
    @Id
    @Column(name ="id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name ="birthday")
    private LocalDate birthday;
    @Column(name = "email")
    private String email;

    public Buyer(Long id, String name, String country, LocalDate birthday,String email) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.email = email;
    }

    public Buyer(String name, String country, LocalDate birthday,String email) {
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.email = email;
    }

    public Buyer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
