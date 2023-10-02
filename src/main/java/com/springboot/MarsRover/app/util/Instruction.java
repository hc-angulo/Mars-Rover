package com.springboot.MarsRover.app.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Instruction {

	@NotEmpty(message = "Este campo es requerido")
	@Pattern(regexp = "^[FfBbLlrR]+$", message = "Sólo se admite cadena de textos con las letras:L,l,B,b,F,f,R,r")
	private String userInstruction;

	public String getUserInstruction() {
		return userInstruction;
	}

	public void setUserInstruction(String userInstruction) {
		this.userInstruction = userInstruction;
	}

	public List<String> stringToListOfStrings(String instruction) {
		String text = instruction.replace(" ", "").toUpperCase();
		List<String> instructions = Stream.of(text.split(" ")).collect(Collectors.toList());
		return instructions;

	}

}