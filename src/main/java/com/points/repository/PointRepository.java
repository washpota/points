package com.points.repository;

import com.points.entity.PointEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PointRepository extends CrudRepository<PointEntity, Long> {

    List<PointEntity> findAllByDateBetween(Date dateStart, Date dateEnd);

}