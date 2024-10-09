package com.points.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.points.entity.PointEntity;
import com.points.model.MonthlyPoints;
import com.points.model.Point;
import com.points.model.PointList;
import com.points.repository.PointRepository;

/**
 * PointService Class
 * 
 * @author ashwin.pakramzis
 */
@Service
public class PointService {
    @Autowired
    private PointRepository pointRepository;

    /**
     * Reads the points for all users from the database and returns the result
     * 
     * @return PointList
     */
    public PointList getPointList() {
//        HashMap<String, ArrayList<PointEntity>> pointEntityMap = new HashMap<String, ArrayList<PointEntity>>();
//        long totalPoints = 0;
        Date toDate = new Date();
        Date fromDate = DateUtils.addMonths(toDate, -3);
        List<String> points = pointRepository.allUsers();
        // Iterable<PointEntity> points = pointRepository.findAllByDateBetween(fromDate, toDate);
        //  Iterator<PointEntity> iterator = points.iterator();
        //  while (iterator.hasNext()) {
        //      PointEntity pes = iterator.next();
        //      System.out.println(pes.getUser());
        //  }
        // //     if(pointEntityMap.containsKey(pes.getUser())){
        //         ArrayList<PointEntity> pointList = (ArrayList<PointEntity>)(pointEntityMap.get(pes.getUser()));
        //         pointList.add(pes);
        //         pointEntityMap.put(pes.getUser(), pointList);
        //     }
        //     else{
        //         ArrayList<PointEntity> pointArray = new ArrayList<PointEntity>();
        //         pointArray.add(pes);
        //         pointEntityMap.put(pes.getUser(), pointArray);
        //     }
        // }
        // HashMap<String, PointList> pointMap = new HashMap<String, PointList>();
        
        // for (Map.Entry<String, ArrayList<PointEntity>> entry : pointEntityMap.entrySet()) {
        //     String user = entry.getKey();
        //     ArrayList<PointEntity> pl = entry.getValue();
        //     for(int i=0; i<pl.size(); i++){
        //         PointEntity pe = pl.get(i);
        //     }
        // }
        return null;
    }

    /**
     * Reads the points for the user from the database and returns the result
     * 
     * @return PointList
     */
    public PointList getPointListByUser(String user) {
        ArrayList<MonthlyPoints> pointArray = new ArrayList<MonthlyPoints>();
        long totalPoints = 0;
        Date toDate = new Date();
        for (int i = 0; i < 3; i++) {
            Date fromDate = DateUtils.addMonths(toDate, -1);
            Iterable<PointEntity> points = pointRepository.findByUserAndDateBetween(user, fromDate, toDate);
            toDate = fromDate;
            Iterator<PointEntity> iterator = points.iterator();
            long pts = 0;
            while (iterator.hasNext()) {
                PointEntity pes = iterator.next();
                pts += pes.getPoints().longValue();
            }
            totalPoints += pts;
            pointArray.add(new MonthlyPoints(fromDate, toDate, pts));
        }
        PointList pl = new PointList();
        pl.setUser(user);
        pl.setTotalPoints(totalPoints);
        pl.setMonthlyPoints(pointArray);
        return pl;
    }

    /**
     * Adds a point transaction to the points table
     * 
     * @return Point
     */
    public Point addPoint(Point point) {
        long pts = 0;
        long amt = point.getAmt().longValue();
        if (amt > 100) {
            pts += (amt - 100) * 2;
            pts += 50;
        } else if (amt > 50) {
            pts += (amt - 50);// *1
        }

        PointEntity pe = new PointEntity();
        pe.setId(point.getTxnid());
        pe.setAmt(point.getAmt());
        pe.setUser(point.getUser());
        pe.setPoints(pts);
        pe.setDate(new Date());
        pointRepository.save(pe);
        return point;
    }
}
