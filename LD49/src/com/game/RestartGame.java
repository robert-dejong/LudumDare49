package com.game;

import com.dependencyinjection.Inject;
import com.game.entity.player.Player;
import com.game.entity.player.PlayerStats;
import com.game.task.TaskManager;
import com.game.world.WorldManager;

public class RestartGame {
	
	@Inject
	private PlayerStats playerStats;
	
	@Inject
	private Player player;
	
	@Inject
	private GameRules gameRules;
	
	@Inject
	private WorldManager worldManager;
	
	@Inject
	private TaskManager taskManager;
	
	public void restart() {
		playerStats.init();
		player.moveTo(0, 100);
		gameRules.init();
		worldManager.init();
		taskManager.reset();
	}

}
