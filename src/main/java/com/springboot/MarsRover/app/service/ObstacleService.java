package com.springboot.MarsRover.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.MarsRover.app.model.Obstacle;
import com.springboot.MarsRover.app.repository.ObstacleRepository;

@Service
public class ObstacleService implements IObstacleService {

	@Autowired
	ObstacleRepository repository;

	@Override
	public List<Obstacle> findAll() {
		List<Obstacle> obstacles = repository.findAll();
		return obstacles;
	}

	@Override
	public void saveObstacle(Obstacle obstacle) {

		repository.save(obstacle);
	}

	@Override
	public void deleteAll() {
		if (this.findAll() != null) {
			repository.deleteAll();
		}
	}

	public void generateObstacles() {
		Random random = new Random();
		Set<Obstacle> obstacles = new HashSet<>();
		int numberOfObstacles = random.nextInt(10) + 1;
		while (obstacles.size() < numberOfObstacles) {
			int randomX = random.nextInt(5) + 1;
			int randomY = random.nextInt(5) + 1;
			obstacles.add(new Obstacle(randomX, randomY));
		}
		obstacles.stream().forEach(obstacle -> {
			this.saveObstacle(obstacle);
		});

	}

	@Override
	public Obstacle findByCoordinateValues(int x, int y) {
		Optional<Obstacle> obstacle = this.findAll().stream().filter(item -> item.getX() == x && item.getY() == y)
				.findFirst();
		return obstacle.orElse(null);
	}

}