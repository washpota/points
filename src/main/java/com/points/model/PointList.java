package com.points.model;

import java.util.ArrayList;

/**
 * PointList Class
 * 
 * @author ashwin.pakramzis
 */
public class PointList {
    private String user;
    private Long totalPoints;
    private ArrayList<MonthlyPoints> monthlyPoints;

    public Long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Long totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<MonthlyPoints> getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(ArrayList<MonthlyPoints> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }
}
