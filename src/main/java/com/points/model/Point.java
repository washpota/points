package com.points.model;

/**
 * Point Class
 * 
 * @author ashwin.pakramzis
 */
public class Point {

    private Long txnid;

    private String user;

    private Long amt;

    public Point(Long txnid, String user, Long amt) {
        this.txnid = txnid;
        this.user = user;
        this.amt = amt;
    }

    public Long getTxnid() {
        return txnid;
    }

    public void setTxnid(Long txnid) {
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

}
