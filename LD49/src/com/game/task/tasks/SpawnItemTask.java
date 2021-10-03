package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.GameRules;
import com.game.entity.Entity;
import com.game.entity.items.BeerItemEntity;
import com.game.entity.player.Player;
import com.game.task.Task;
import com.game.world.WorldManager;

public class SpawnItemTask extends Task {
	
	private final static int ITEM_COUNT = 1;
	private final static int MINIMUM_DELAY_BETWEEN_SPAWNS = 200;

	@Inject
	private WorldManager worldManager;
	
	@Inject
	private Player player;
	
	@Inject
	private GameRules gameRules;
	
	private int ticksToWait;
	
	public SpawnItemTask() {
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
		
		int id = (int)(Math.random() * ITEM_COUNT) + 1;
		double x = player.getX() + (Constants.TILE_SIZE * 10);
		double y = Constants.MIN_Y_POSITION + (int)(Math.random() * (Constants.MAX_Y_POSITION - Constants.MIN_Y_POSITION));
		
		Entity entity = getEntity(id, x, y);
		
		worldManager.addEntity(entity);
		ticksToWait = getNextSpawnTicks();
	}
	
	private int getNextSpawnTicks() {
		return (int)(Math.random() * gameRules.getItemSpawnRate()) + MINIMUM_DELAY_BETWEEN_SPAWNS;
	}
	
	private Entity getEntity(int id, double x, double y) {
		switch(id) {
		case 1:
			return new BeerItemEntity(x, y);
		}
		
		return null;
	}

}
