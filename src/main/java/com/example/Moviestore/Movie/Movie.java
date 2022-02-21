package com.example.Moviestore.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "available")
    private boolean available;
    @Column(name = "releaseyear")
    private Integer releaseyear;
    @Column(name = "director_id")
    private Long director_id;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "genre")
    private String genre;

    public Movie(Long id, String name, boolean available, Integer releaseyear, Long director_od, Integer rating, String genre) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.releaseyear = releaseyear;
        this.director_id = director_od;
        this.rating = rating;
        this.genre = genre;
    }

    public Movie(String name, boolean available, Integer releaseyear, Long director_od, Integer rating, String genre) {
        this.name = name;
        this.available = available;
        this.releaseyear = releaseyear;
        this.director_id = director_od;
        this.rating = rating;
        this.genre = genre;
    }

    public Movie() {
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(Integer releaseyear) {
        this.releaseyear = releaseyear;
    }

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_od) {
        this.director_id = director_od;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
