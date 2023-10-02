package com.springboot.MarsRover.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.MarsRover.app.model.Cardinality;
import com.springboot.MarsRover.app.model.Obstacle;
import com.springboot.MarsRover.app.util.Instruction;
import com.springboot.MarsRover.app.util.Result;
import com.springboot.MarsRover.app.util.RoverPositionAndObstacle;
import com.springboot.MarsRover.app.model.RoverPosition;
import com.springboot.MarsRover.app.repository.RoverPositionRepository;

@Service
public class RoverPositionService implements IRoverPositionService {
	@Autowired
	MovementService movementService;
	
	@Autowired
	private RoverPositionRepository repository;

	@Autowired
	private IObstacleService obstacleService;

	@Override
	public List<RoverPosition> findAll() {
		return repository.findAll();
	}

	@Override
	public RoverPosition getLastPosition() {

		return repository.lastPosition();

	}

	@Override
	public void savePosition(RoverPosition position) {

		repository.save(position);

	}

	@Override
	public RoverPosition findById(Long id) {
		RoverPosition position = repository.findById(id).orElse(null);
		return position;

	}

	@Override
	public void deleteAll() {
		if (this.findAll() != null) {
			repository.deleteAll();
		}
	}

	@Override
	public RoverPosition findByMinimumId() {
		RoverPosition position = repository.findByMinimumId();
		return position;
	}

	// ---- Create init conditions ----//

	public void createInitConditions() {
		obstacleService.generateObstacles();
		RoverPosition initPosition = new RoverPosition(0, 0, Cardinality.NORTH);
		this.savePosition(initPosition);
	}

	// ------ Input data ------//
	public Result inputData(Instruction instruction) {

		List<Character> charList = instruction.getUserInstruction().chars().mapToObj(c -> (char) c)
				.collect(Collectors.toList());

		List<String> instructions = charList.stream().map(String::valueOf).collect(Collectors.toList());

		RoverPosition roverPosition = this.getLastPosition();
		return this.move(instructions, roverPosition);
	}

	// ------ Results ------//

	private Result move(List<String> instructions, RoverPosition roverPosition) {

		Result result = new Result();
		RoverPositionAndObstacle obstacle = new RoverPositionAndObstacle();
		List<String> inputInstructionAndExecutedInstruction = new ArrayList<>();
		String inputInstruction = String.join("", instructions);
		inputInstructionAndExecutedInstruction.add(inputInstruction);
		List<RoverPosition> positionHistory = new ArrayList<>();
		positionHistory.add(roverPosition);
		int x = roverPosition.getX();
		int y = roverPosition.getY();
		Cardinality cardinality = roverPosition.getCardinality();
		String sbToString;
		StringBuilder sb = new StringBuilder("");
		for (String instruction : instructions) {
			RoverPosition currentPosition = positionHistory.get(positionHistory.size() - 1);
			RoverPositionAndObstacle newPosition = this.executeInstruction(instruction, currentPosition);
			if (newPosition.getRoverPosition() != null) {
				positionHistory.add(newPosition.getRoverPosition());
				sb.append(instruction);
			} else {
				obstacle.setObstacle(newPosition.getObstacle());
				break;
			}
		}
		String instructionsExecuted = !sb.toString().isEmpty() ? sb.toString()
				: "No se ejecutaron ninguna de tus instrucciones :-(";
		if (positionHistory.size() > 1) {
			this.savePosition(positionHistory.get(positionHistory.size() - 1));
		}
		inputInstructionAndExecutedInstruction.add(instructionsExecuted);
		result.setRoverPositions(positionHistory);
		result.setMessages(inputInstructionAndExecutedInstruction);
		result.setRoverAndObs(obstacle);
		return result;
	}

	private RoverPositionAndObstacle executeInstruction(String instruction, RoverPosition currentPosition) {
		
		switch (instruction) {
		case "F":
			return movementService.moveForward(currentPosition);
		case "B":
			return movementService.moveBackward(currentPosition);
		case "L":
			return movementService.turnLeft(currentPosition);
		case "R":
			return movementService.turnRight(currentPosition);
		default:
			throw new IllegalArgumentException("Instrucción inválida: " + instruction);
		}
	}

}
