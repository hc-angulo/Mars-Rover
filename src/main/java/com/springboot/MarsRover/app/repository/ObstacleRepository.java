package com.springboot.MarsRover.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.MarsRover.app.model.Obstacle;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle,Long>{

}

