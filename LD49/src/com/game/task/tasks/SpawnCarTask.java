package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.entity.objects.CarEntity;
import com.game.entity.player.Player;
import com.game.task.Task;
import com.game.world.WorldManager;

public class SpawnCarTask extends Task {

	@Inject
	private WorldManager worldManager;
	
	@Inject
	private Player player;
	
	@Inject
	private GameRules gameRules;
	
	private int ticksToWait;
	
	public SpawnCarTask() {
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
		
		int direction = (int)(Math.random() * 2);
		int playerX = player.getTileX(player.getX());
		int x = playerX + (direction == 0 ? -15 : 15);
		int y = direction == 0 ? 8 : 9;
		
		worldManager.addEntity(new CarEntity(x, y, direction));
		ticksToWait = getNextSpawnTicks();
	}
	
	private int getNextSpawnTicks() {
		return (int)(Math.random() * gameRules.getCarSpawnRate()) + gameRules.getMinimumCarSpawnRate();
	}

}
