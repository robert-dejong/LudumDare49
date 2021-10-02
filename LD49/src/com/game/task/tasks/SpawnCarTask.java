package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.entity.objects.CarEntity;
import com.game.entity.player.Player;
import com.game.task.Task;
import com.game.world.WorldManager;

public class SpawnCarTask extends Task {
	
	private final static int MINIMUM_DELAY_BETWEEN_SPAWNS = 200;
	private final static int SPAWN_RATE = 200;

	@Inject
	private WorldManager worldManager;
	
	@Inject
	private Player player;
	
	private int ticksToWait;
	
	public SpawnCarTask() {
		super(1, true);
		this.ticksToWait = getNextSpawnTicks();
	}

	@Override
	public void execute() {
		ticksToWait--;
		
		if(ticksToWait > 0)
			return;
		
		int direction = (int)(Math.random() * 2);
		int playerX = player.getTileX(player.getX());
		int x = playerX + (direction == 0 ? -15 : 15);
		int y = direction == 0 ? 8 : 9;
		
		worldManager.addEntity(new CarEntity(x, y, direction));
		ticksToWait = getNextSpawnTicks();
	}
	
	private int getNextSpawnTicks() {
		return (int)(Math.random() * SPAWN_RATE) + MINIMUM_DELAY_BETWEEN_SPAWNS;
	}

}
