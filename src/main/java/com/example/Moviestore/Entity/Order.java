package com.example.Moviestore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "OPENORDER")
    private Boolean openorder;

    @Column(name = "ORDERDATE")
    private Date orderdate;

    @Column(name = "MOVIE_ID")
    private Long movie_id;

    @Column(name = "BUYER_ID")
    private Long buyer_id;

    public Order(Long id, Boolean openorder, Date orderdate, Long movie_id, Long buyer_id) {
        this.id = id;
        this.openorder = openorder;
        this.orderdate = orderdate;
        this.movie_id = movie_id;
        this.buyer_id = buyer_id;
    }

    public Order(Boolean openorder, Date orderdate, Long movie_id, Long buyer_id) {
        this.openorder = openorder;
        this.orderdate = orderdate;
        this.movie_id = movie_id;
        this.buyer_id = buyer_id;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOpenorder() {
        return openorder;
    }

    public void setOpenorder(Boolean openorder) {
        this.openorder = openorder;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }
}
