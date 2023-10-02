package com.springboot.MarsRover.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.MarsRover.app.model.RoverPosition;

import jakarta.transaction.Transactional;

@Repository
public interface RoverPositionRepository extends JpaRepository<RoverPosition, Long> {

	@Transactional
	@Query("SELECT p FROM RoverPosition p ORDER BY p.id DESC LIMIT 1")
	public RoverPosition lastPosition();

	@Transactional
	@Query("SELECT p FROM RoverPosition p WHERE p.id = (SELECT MIN(id) FROM RoverPosition)")
	public RoverPosition findByMinimumId();
}
