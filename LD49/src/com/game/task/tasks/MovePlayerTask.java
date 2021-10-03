package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.entity.player.Player;
import com.game.entity.player.PlayerStats;
import com.game.task.Task;

public class MovePlayerTask extends Task {
	
	@Inject
	private Player player;
	
	@Inject
	private PlayerStats playerStats;
	
	@Inject
	private GameRules gameRules;
	
	public MovePlayerTask() {
		super(1, true);
	}

	@Override
	public void execute() {
		player.move(gameRules.getPlayerMovementSpeed(), 0);
		playerStats.addDistance(1);
	}

}
