package com.points.repository;

import com.points.entity.PointEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * PointRepository Class
 * 
 * @author ashwin.pakramzis
 */
public interface PointRepository extends CrudRepository<PointEntity, Long> {

    /**
     * Finds all point transactions in the past three month period
     * 
     * @return List of Point entities
     */
    List<PointEntity> findAllByDateBetween(Date dateStart, Date dateEnd);

    /**
     * Finds all users
     * 
     * @return List of users
     */
    @Query("SELECT DISTINCT user FROM points.point")
    List<String> allUsers();

    /**
     * Finds all point transactions for the user in the past three month period
     * 
     * @return List of Point entities
     */
    List<PointEntity> findByUserAndDateBetween(String user, Date dateStart, Date dateEnd);

}