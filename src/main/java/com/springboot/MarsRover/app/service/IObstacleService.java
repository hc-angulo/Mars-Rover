package com.springboot.MarsRover.app.service;

import java.util.List;

import com.springboot.MarsRover.app.model.Obstacle;

public interface IObstacleService {

	public List<Obstacle> findAll();

	public void saveObstacle(Obstacle obstacle);

	public void deleteAll();

	public Obstacle findByCoordinateValues(int x, int y);

	public void generateObstacles();

}
