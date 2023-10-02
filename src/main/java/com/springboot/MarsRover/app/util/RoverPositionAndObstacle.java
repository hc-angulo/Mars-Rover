package com.springboot.MarsRover.app.util;

import com.springboot.MarsRover.app.model.Obstacle;
import com.springboot.MarsRover.app.model.RoverPosition;

public class RoverPositionAndObstacle {

	private RoverPosition roverPosition;

	private Obstacle obstacle;

	public RoverPositionAndObstacle() {

	}

	public RoverPosition getRoverPosition() {
		return roverPosition;
	}

	public void setRoverPosition(RoverPosition roverPosition) {
		this.roverPosition = roverPosition;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

}
