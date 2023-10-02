package com.springboot.MarsRover.app.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.MarsRover.app.model.Cardinality;
import com.springboot.MarsRover.app.model.RoverPosition;
import com.springboot.MarsRover.app.service.IObstacleService;
import com.springboot.MarsRover.app.service.IRoverPositionService;
import com.springboot.MarsRover.app.util.Instruction;
import com.springboot.MarsRover.app.util.Result;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/marsRover")
public class RoverPositionController {

	@Autowired
	private IRoverPositionService roverPosition;

	@Autowired
	private IObstacleService obstacleService;

	@GetMapping("")
	public String index(Model model) {
		RoverPosition position = roverPosition.findByMinimumId();
		model.addAttribute("position", position);
		return "index";
	}

	@PostMapping("")
	public String create(RoverPosition position, Model model) {

		if (position.getId() == null) {
			roverPosition.createInitConditions();
			return "redirect:/api/marsRover/instructions";

		}
		roverPosition.deleteAll();
		obstacleService.deleteAll();
		return "redirect:/api/marsRover";

	}

	@GetMapping("/instructions")
	public String instructions(Model model) {
		Instruction instruction = new Instruction();
		model.addAttribute("titulo", "Inserta tus instrucciones");
		model.addAttribute("instruction", instruction);
		return "instructions";
	}

	@PostMapping("/result")
	public String recordMovements(@Valid Instruction instruction, BindingResult validation, Model model) {
		if (validation.hasErrors()) {
			return "instructions";
		}
		Result result = roverPosition.inputData(instruction);
		model.addAttribute("result", result);
		return "result";
	}
}
