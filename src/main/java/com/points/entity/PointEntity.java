package com.points.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PointEntity Class
 * 
 * @author ashwin.pakramzis
 */
@Entity
@Table(name = "point")
public class PointEntity {
    @Id
    @Column(nullable = false)
    private Long txnid;

    public PointEntity(Long txnid, String user, Long amt, Long points, Date date) {
        this.txnid = txnid;
        this.user = user;
        this.amt = amt;
        this.points = points;
        this.date = date;
    }

    public PointEntity() {
        this.txnid = null;
        this.user = null;
        this.amt = null;
        this.points = null;
        this.date = null;
    }

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private Long amt;

    @Column(nullable = false)
    private Long points;

    @Column(nullable = false)
    private Date date;

    public Long getId() {
        return txnid;
    }

    public void setId(Long txnid) {
        this.txnid = txnid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
