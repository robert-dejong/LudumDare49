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
		playerMovementSpeed = 1.0;
		carSpeed = 2.0;
		CarSpawnRate = 200;
		obstacleSpawnRate = 200;
		itemSpawnRate = 250;
		minimumCarSpawnRate = 200;
		minimumObstacleSpawnRate = 100;
		difficultyLevel = 0;
	}
	
	public void increasePlayerMovementSpeed(double amount) {
		this.playerMovementSpeed += amount;
	}
	
	public void increaseCarSpeed(double amount) {
		this.carSpeed += amount;
	}
	
	public void increaseCarSpawnRate(double amount) {
		this.CarSpawnRate -= amount;
	}
	
	public void increaseObstacleSpawnRate(double amount) {
		this.obstacleSpawnRate -= amount;
	}
	
	public void decreaseItemSpawnRate(double amount) {
		this.itemSpawnRate += amount;
	}
	
	public void decreaseMinimumCarSpawnRate(double amount) {
		this.minimumCarSpawnRate -= amount;
	}
	
	public void decreaseMinimumObstacleSpawnRate(double amount) {
		this.minimumObstacleSpawnRate -= amount;
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
