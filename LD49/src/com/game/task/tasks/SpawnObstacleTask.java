package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.GameRules;
import com.game.entity.Entity;
import com.game.entity.objects.BrokenGlassEntity;
import com.game.entity.player.Player;
import com.game.task.Task;
import com.game.world.WorldManager;

public class SpawnObstacleTask extends Task {
	
	private final static int OBSTACLE_COUNT = 1;

	@Inject
	private WorldManager worldManager;
	
	@Inject
	private Player player;
	
	@Inject
	private GameRules gameRules;
	
	private int ticksToWait;
	
	public SpawnObstacleTask() {
		super(1, true);
	}
	
	@Override
	public void onCreate() {
		this.ticksToWait = getNextSpawnTicks();
	}

	@Override
	public void execute() {
		ticksToWait--;
		
		if(ticksToWait > 0)
			return;
		
		int id = (int)(Math.random() * OBSTACLE_COUNT) + 1;
		double x = (int)(Math.random() * 120) + player.getX() + (Constants.TILE_SIZE * 10);
		double y = Constants.MIN_Y_POSITION + (int)(Math.random() * (Constants.MAX_Y_POSITION - Constants.MIN_Y_POSITION));
		
		Entity entity = getEntity(id, x, y);
		
		worldManager.addEntity(entity);
		
		if(spawnAnotherObstacle()) {
			execute();
			System.out.println("SPAWNED another obstacle");
		}
		
		ticksToWait = getNextSpawnTicks();
	}
	
	private int getNextSpawnTicks() {
		return (int)(Math.random() * gameRules.getObstacleSpawnRate()) + gameRules.getMinimumObstacleSpawnRate();
	}
	
	private Entity getEntity(int id, double x, double y) {
		switch(id) {
		case 1:
			return new BrokenGlassEntity(x, y);
		}
		
		return null;
	}
	
	private boolean spawnAnotherObstacle() {
		int chance = 10;
		
		chance = chance - (gameRules.getDifficultyLevel() / 10);
		
		if(chance < 2)
			chance = 2;
		
		return (int)(Math.random() * chance) == 0;
	}

}
