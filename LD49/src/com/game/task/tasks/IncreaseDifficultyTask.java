package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.task.Task;

public class IncreaseDifficultyTask extends Task {
	
	@Inject
	private GameRules gameRules;
	
	public IncreaseDifficultyTask() {
		super(120, true);
	}

	@Override
	public void execute() {
		gameRules.increaseDifficultyLevel();
		int difficultyLevel = gameRules.getDifficultyLevel();
		
		if(difficultyLevel <= 5) {
			gameRules.increaseCarSpeed(0.07);
		}
		
		if(difficultyLevel <= 10) {
			gameRules.increaseObstacleSpawnRate(1);
		}
		
		if(difficultyLevel <= 20) {
			gameRules.increaseCarSpawnRate(5);
		}
		
		if(difficultyLevel <= 30) {
			gameRules.increasePlayerMovementSpeed(0.011);
			gameRules.increaseObstacleSpawnRate(4);
			gameRules.decreaseMinimumCarSpawnRate(2);
		}
		
		if(difficultyLevel <= 50) {
			gameRules.decreaseItemSpawnRate(3);
			gameRules.decreaseMinimumObstacleSpawnRate(2);
			gameRules.increasePlayerMovementSpeed(0.012);
		}
		
		if(difficultyLevel >= 50 && difficultyLevel <= 75) {
			gameRules.decreaseItemSpawnRate(5);
			gameRules.increasePlayerMovementSpeed(0.015);
			gameRules.increaseCarSpeed(0.02);
			gameRules.increaseObstacleSpawnRate(1);
		}
		
		if(difficultyLevel > 75) {
			gameRules.increasePlayerMovementSpeed(0.007);
			gameRules.increaseCarSpeed(0.01);
			gameRules.decreaseItemSpawnRate(3);
		}
	}

}
