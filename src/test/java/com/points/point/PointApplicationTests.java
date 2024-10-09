package com.points.point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.points.controller.PointController;
import com.points.entity.PointEntity;
import com.points.model.Point;
import com.points.model.PointList;
import com.points.repository.PointRepository;
import com.points.service.PointService;

@SpringBootTest
class PointApplicationTests {

	@Autowired
	PointRepository pointRepository;

	@Autowired
	PointController pointController;

	@Autowired
	PointService pointService;

	@Test
	void testAddPointController() {
		Point point = new Point(Long.valueOf(1001), "ashwin", Long.valueOf(500));
		ResponseEntity<Point> re = pointController.addPoint(point);
		assertEquals(HttpStatus.OK, re.getStatusCode());
		assertEquals(point, re.getBody());
	}

	@Test
	void testGetPointsController() {
		ResponseEntity<PointList> re = pointController.getPoints("ashwin");
		assertEquals(HttpStatus.OK, re.getStatusCode());
		assertEquals("ashwin", re.getBody().getUser());
		assertFalse(re.getBody().getMonthlyPoints().isEmpty());
	}

	@Test
	void testAddPointService() {
		Point point = new Point(Long.valueOf(1001), "ashwin", Long.valueOf(500));
		Point pt = pointService.addPoint(point);
		assertEquals(point, pt);
	}

	// @Test
	// void testGetPointsService() {
	// 	PointList pl = pointService.getPointList("ashwin");
	// 	assertEquals("ashwin", pl.getUser());
	// 	assertFalse(pl.getMonthlyPoints().isEmpty());
	// }

	@Test
	void testAddPointRepisitory() {
		PointEntity pe = new PointEntity(Long.valueOf(1001), "ashwin", Long.valueOf(500), Long.valueOf(850), new Date());
		pointRepository.save(pe);
		assertNotNull(pointRepository.findById(Long.valueOf(1001)).get());
	}

	@Test
	void testFindByUserAndDateBetweenRepository() {
		Date toDate = new Date();
		Date fromDate = DateUtils.addMonths(toDate, -1);
		List<PointEntity> pes = pointRepository.findByUserAndDateBetween("ashwin", fromDate, toDate);
		assertFalse(pes.isEmpty());
	}

}
