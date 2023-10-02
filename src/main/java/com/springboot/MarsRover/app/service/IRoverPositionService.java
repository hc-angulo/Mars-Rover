package com.springboot.MarsRover.app.service;

import java.util.List;

import com.springboot.MarsRover.app.model.RoverPosition;
import com.springboot.MarsRover.app.util.Instruction;
import com.springboot.MarsRover.app.util.Result;

public interface IRoverPositionService {

	public List<RoverPosition> findAll();

	public Result inputData(Instruction instruction);

	public RoverPosition getLastPosition();

	public void savePosition(RoverPosition position);

	public void createInitConditions();

	public RoverPosition findById(Long id);

	public void deleteAll();

	public RoverPosition findByMinimumId();

}
