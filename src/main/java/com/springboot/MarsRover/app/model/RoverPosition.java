package com.springboot.MarsRover.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
public class RoverPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private int x;

	@Column
	private int y;

	@Enumerated(EnumType.STRING)
	private Cardinality cardinality;

	public RoverPosition() {

	}

	public RoverPosition(Long id, int x, int y, Cardinality cardinality) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.cardinality = cardinality;
	}

	public RoverPosition(int x, int y, Cardinality cardinality) {
		this.x = x;
		this.y = y;
		this.cardinality = cardinality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Cardinality getCardinality() {
		return cardinality;
	}

	public void setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality;
	}

	@Override
	public String toString() {
		return "x= " + x + ", y=" + y + ", cardinality=" + cardinality;
	}

}
