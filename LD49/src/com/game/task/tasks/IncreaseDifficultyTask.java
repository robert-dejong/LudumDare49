package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.task.Task;

public class IncreaseDifficultyTask extends Task {
	
	@Inject
	private GameRules gameRules;
	
	public IncreaseDifficultyTask() {
		super(180, true);
	}

	@Override
	public void execute() {
		gameRules.increaseDifficultyLevel();
		int difficultyLevel = gameRules.getDifficultyLevel();
		
		if(difficultyLevel <= 5) {
			gameRules.increaseCarSpeed(0.07);
		}
		
		if(difficultyLevel <= 10) {
			gameRules.increasePlayerMovementSpeed(0.05);
		}
		
		if(difficultyLevel <= 20) {
			gameRules.increaseCarSpawnRate(5);
		}
		
		if(difficultyLevel <= 30) {
			gameRules.increaseObstacleSpawnRate(5);
			gameRules.decreaseMinimumCarSpawnRate(2);
		}
		
		if(difficultyLevel <= 50) {
			gameRules.decreaseItemSpawnRate(3);
			gameRules.decreaseMinimumObstacleSpawnRate(2);
		}
		
		if(difficultyLevel >= 50 && difficultyLevel <= 75) {
			gameRules.decreaseItemSpawnRate(5);
			gameRules.increasePlayerMovementSpeed(0.03);
			gameRules.increaseCarSpeed(0.02);
			gameRules.increaseObstacleSpawnRate(1);
		}
		
		if(difficultyLevel > 75) {
			gameRules.increasePlayerMovementSpeed(0.02);
			gameRules.increaseCarSpeed(0.02);
			gameRules.decreaseItemSpawnRate(3);
		}
		
		System.out.println("Difficulty: " + difficultyLevel + ", playerSpeed: " + gameRules.getPlayerMovementSpeed() + ", carSpeed: " + gameRules.getCarSpeed() + ", carSpawnRate: " + gameRules.getCarSpawnRate() + ", obstacleSpawnRate: " + gameRules.getObstacleSpawnRate() + ", itemSpawnRate: " + gameRules.getItemSpawnRate() + ", minimumCarSpawnRate: " + gameRules.getMinimumCarSpawnRate() + ", minimumObstacleSpawnRate: " + gameRules.getMinimumObstacleSpawnRate());
	}

}
