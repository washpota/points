package com.points.repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.points.entity.MonthlyPoints;
import com.points.entity.PointEntity;
import com.points.entity.PointList;
import com.points.service.PointService;

@RestController
public class PointController {

	@Autowired
	private PointRepository pointRepository;
	
	@GetMapping("/points")
	public PointService getPoints() {

		Long[] pointArr = new Long[3];
		ArrayList<MonthlyPoints> pointArray = new ArrayList<MonthlyPoints>();
		Date toDate = new Date();
		for (int i=0; i<pointArr.length; i++){
			Date fromDate = DateUtils.addMonths(toDate, -1);
			Iterable<PointEntity> points = pointRepository.findAllByDateBetween(fromDate, toDate);
			toDate = fromDate;
			Iterator<PointEntity> iterator = points.iterator();
			long pts = 0;
			while(iterator.hasNext()){
				PointEntity pes = iterator.next();
				Long amt = pes.getAmt();
				if(amt > 200){
					pts += (amt-200)*2;
					pts += 50;
				}
				else if(amt>100){
					pts += (amt-100);//*1 
				}
			}
			pointArray.add(new MonthlyPoints(fromDate, toDate, pts));
		}
		PointList pl = new PointList();
		pl.setMonthlyPoints(pointArray);
		return new PointService(pl);
	}
}