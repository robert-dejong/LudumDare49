package com.game;

public class GameRules {
	
	private double playerMovementSpeed;
	private double carSpeed;
	private int CarSpawnRate;
	private int obstacleSpawnRate;
	private int itemSpawnRate;
	private int minimumCarSpawnRate;
	private int minimumObstacleSpawnRate;
	private int difficultyLevel;
	
	public GameRules() {
		init();
	}
	
	public void init() {
		playerMovementSpeed = 1.05;
		carSpeed = 2.0;
		CarSpawnRate = 200;
		obstacleSpawnRate = 190;
		itemSpawnRate = 250;
		minimumCarSpawnRate = 200;
		minimumObstacleSpawnRate = 90;
		difficultyLevel = 0;
	}
	
	public void increasePlayerMovementSpeed(double amount) {
		this.playerMovementSpeed += amount;
	}
	
	public void increaseCarSpeed(double amount) {
		this.carSpeed += amount;
	}
	
	public void increaseCarSpawnRate(int amount) {
		this.CarSpawnRate -= amount;
		
		if(this.CarSpawnRate < 0) {
			this.CarSpawnRate = 0;
		}
	}
	
	public void increaseObstacleSpawnRate(int amount) {
		this.obstacleSpawnRate -= amount;
		
		if(this.obstacleSpawnRate < 0) {
			this.obstacleSpawnRate = 0;
		}
	}
	
	public void decreaseItemSpawnRate(int amount) {
		this.itemSpawnRate += amount;
	}
	
	public void decreaseMinimumCarSpawnRate(int amount) {
		this.minimumCarSpawnRate -= amount;
		
		if(this.minimumCarSpawnRate < 0) {
			this.minimumCarSpawnRate = 0;
		}
	}
	
	public void decreaseMinimumObstacleSpawnRate(int amount) {
		this.minimumObstacleSpawnRate -= amount;
		
		if(this.minimumObstacleSpawnRate < 0) {
			this.minimumObstacleSpawnRate = 0;
		}
	}
	
	public void increaseDifficultyLevel() {
		this.difficultyLevel++;
	}

	public double getPlayerMovementSpeed() {
		return playerMovementSpeed;
	}

	public double getCarSpeed() {
		return carSpeed;
	}

	public int getCarSpawnRate() {
		return CarSpawnRate;
	}

	public int getObstacleSpawnRate() {
		return obstacleSpawnRate;
	}

	public int getItemSpawnRate() {
		return itemSpawnRate;
	}
	
	public int getMinimumCarSpawnRate() {
		return minimumCarSpawnRate;
	}

	public int getMinimumObstacleSpawnRate() {
		return minimumObstacleSpawnRate;
	}
	
	public int getDifficultyLevel() {
		return difficultyLevel;
	}

}
