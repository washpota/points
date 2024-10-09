package com.points.model;

import java.util.Date;

/**
 * MonthlyPoints Class
 * 
 * @author ashwin.pakramzis
 */
public class MonthlyPoints {
    private Date startDate;
    private Date endDate;
    private Long points;

    public MonthlyPoints(Date startDate, Date endDate, Long points) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.points = points;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Long getPoints() {
        return points;
    }
    public void setPoints(Long points) {
        this.points = points;
    }
}
