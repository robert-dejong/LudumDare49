package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.entity.player.Player;
import com.game.task.Task;

public class MovePlayerTask extends Task {
	
	@Inject
	private Player player;
	
	public MovePlayerTask() {
		super(1, true);
	}

	@Override
	public void execute() {
		player.move(1, 0);
	}

}
