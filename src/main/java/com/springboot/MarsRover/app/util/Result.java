package com.springboot.MarsRover.app.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.springboot.MarsRover.app.model.RoverPosition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private List<RoverPosition> roverPositions;

	private List<String> messages;

	private RoverPositionAndObstacle roverAndObs;

	public List<RoverPosition> getRoverPositions() {
		return roverPositions;
	}

	public void setRoverPositions(List<RoverPosition> roverPositions) {
		this.roverPositions = roverPositions;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public RoverPositionAndObstacle getRoverAndObs() {
		return roverAndObs;
	}

	public void setRoverAndObs(RoverPositionAndObstacle roverAndObs) {
		this.roverAndObs = roverAndObs;
	}

}
