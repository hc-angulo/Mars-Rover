package com.springboot.MarsRover.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.MarsRover.app.model.Cardinality;
import com.springboot.MarsRover.app.model.Obstacle;
import com.springboot.MarsRover.app.model.RoverPosition;
import com.springboot.MarsRover.app.util.RoverPositionAndObstacle;

@Service
class MovementService {

	public static final int GRID_SIZE = 6;

	@Autowired
	IObstacleService obstacleService;

	// ------ FORWARD -------//

	public RoverPositionAndObstacle moveForward(RoverPosition currentPosition) {
		RoverPositionAndObstacle combinedData = new RoverPositionAndObstacle();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		Cardinality cardinality = currentPosition.getCardinality();
		RoverPosition newCurrentPosition = new RoverPosition();
		int temporalVariable;
		newCurrentPosition.setCardinality(cardinality);
		Obstacle obstacle;
		switch (cardinality) {
		case NORTH:
			temporalVariable = (y + 1) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(x, temporalVariable);
			if (obstacle == null) {
				newCurrentPosition.setX(x);
				newCurrentPosition.setY(temporalVariable);
				combinedData.setRoverPosition(newCurrentPosition);
			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		case EAST:
			temporalVariable = (x + 1) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(temporalVariable, y);
			if (obstacle == null) {
				newCurrentPosition.setX(temporalVariable);
				newCurrentPosition.setY(y);
				combinedData.setRoverPosition(newCurrentPosition);
			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		case SOUTH:
			temporalVariable = (y - 1 + GRID_SIZE) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(x, temporalVariable);
			if (obstacle == null) {
				newCurrentPosition.setX(x);
				newCurrentPosition.setY(temporalVariable);
				combinedData.setRoverPosition(newCurrentPosition);
			} else {
				combinedData.setObstacle(obstacle);
			}
			break;

		case WEST:
			temporalVariable = (x - 1 + GRID_SIZE) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(temporalVariable, y);
			if (obstacle == null) {
				newCurrentPosition.setX(temporalVariable);
				newCurrentPosition.setY(y);
				combinedData.setRoverPosition(newCurrentPosition);
			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		}

		return combinedData;
	}

	// ----- BACKWARD ------ //

	public RoverPositionAndObstacle moveBackward(RoverPosition currentPosition) {
		RoverPositionAndObstacle combinedData = new RoverPositionAndObstacle();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		Cardinality cardinality = currentPosition.getCardinality();
		RoverPosition newCurrentPosition = new RoverPosition();
		int temporalVariable;
		newCurrentPosition.setCardinality(cardinality);
		Obstacle obstacle;

		switch (cardinality) {
		case NORTH:
			temporalVariable = (y - 1 + GRID_SIZE) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(x, temporalVariable);
			if (obstacle == null) {
				newCurrentPosition.setY(temporalVariable);
				newCurrentPosition.setX(x);
				combinedData.setRoverPosition(newCurrentPosition);

			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		case EAST:
			temporalVariable = (x - 1 + GRID_SIZE) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(temporalVariable, y);
			if (obstacle == null) {
				newCurrentPosition.setX(temporalVariable);
				newCurrentPosition.setY(y);
				combinedData.setRoverPosition(newCurrentPosition);

			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		case SOUTH:
			temporalVariable = (y + 1) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(x, temporalVariable);
			if (obstacle == null) {
				newCurrentPosition.setY(temporalVariable);
				newCurrentPosition.setX(x);
				combinedData.setRoverPosition(newCurrentPosition);

			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		case WEST:
			temporalVariable = (x + 1) % GRID_SIZE;
			obstacle = obstacleService.findByCoordinateValues(temporalVariable, y);
			if (obstacle == null) {
				newCurrentPosition.setX(temporalVariable);
				newCurrentPosition.setY(y);
				combinedData.setRoverPosition(newCurrentPosition);

			} else {
				combinedData.setObstacle(obstacle);
			}
			break;
		}
		return combinedData;
	}

	// -------- LEFT ---------//

	public RoverPositionAndObstacle turnLeft(RoverPosition currentPosition) {
		RoverPositionAndObstacle combinedData = new RoverPositionAndObstacle();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		Cardinality cardinality = currentPosition.getCardinality();
		RoverPosition newCurrentPosition = new RoverPosition();
		newCurrentPosition.setX(x);
		newCurrentPosition.setY(y);
		switch (cardinality) {
		case NORTH:
			newCurrentPosition.setCardinality(Cardinality.WEST);
			break;
		case EAST:
			newCurrentPosition.setCardinality(Cardinality.NORTH);
			break;
		case SOUTH:
			newCurrentPosition.setCardinality(Cardinality.EAST);
			break;
		case WEST:
			newCurrentPosition.setCardinality(Cardinality.SOUTH);
			break;
		}
		combinedData.setRoverPosition(newCurrentPosition);
		return combinedData;
	}

	// ------ RIGHT -------//

	public RoverPositionAndObstacle turnRight(RoverPosition currentPosition) {
		RoverPositionAndObstacle combinedData = new RoverPositionAndObstacle();
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		Cardinality cardinality = currentPosition.getCardinality();
		RoverPosition newCurrentPosition = new RoverPosition();
		newCurrentPosition.setX(x);
		newCurrentPosition.setY(y);
		switch (cardinality) {
		case NORTH:
			newCurrentPosition.setCardinality(Cardinality.EAST);
			break;
		case EAST:
			newCurrentPosition.setCardinality(Cardinality.SOUTH);
			break;
		case SOUTH:
			newCurrentPosition.setCardinality(Cardinality.WEST);
			break;

		case WEST:
			newCurrentPosition.setCardinality(Cardinality.NORTH);
		}
		combinedData.setRoverPosition(newCurrentPosition);
		return combinedData;
	}

}
