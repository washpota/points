package com.points.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.points.service.PointService;
import com.points.model.Point;
import com.points.model.PointList;

/**
 * PointController Class
 * 
 * @author ashwin.pakramzis
 */
@RestController
public class PointController {

    @Autowired
    PointService pointService;

    @GetMapping("/points")
    public ResponseEntity<PointList> getAllPoints() {
        return new ResponseEntity<PointList>(pointService.getPointList(), HttpStatus.OK);
    }

    @GetMapping("/points/{user}")
    public ResponseEntity<PointList> getPoints(@PathVariable(value="user") String user) {
        return new ResponseEntity<PointList>(pointService.getPointListByUser(user), HttpStatus.OK);
    }

    @PostMapping("/add_point")
    public ResponseEntity<Point> addPoint(@RequestBody Point point) {
        return new ResponseEntity<>(pointService.addPoint(point), HttpStatus.CREATED);
    }

    // @GetMapping("/points_between")
    // public ResponseEntity<PointList> addPointsBetween(@RequestParam("user") String user, @RequestParam("endDate") Date endDate) {
    // return new ResponseEntity<PointList>(pointService.getPointList(user, endDate), HttpStatus.OK);
    // }
}