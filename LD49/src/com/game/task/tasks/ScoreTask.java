package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.entity.player.PlayerStats;
import com.game.task.Task;

public class ScoreTask extends Task {
	
	@Inject
	private PlayerStats playerStats;
	
	public ScoreTask() {
		super(Constants.SCORE_INCREASE_RATE, true);
	}

	@Override
	public void execute() {
		playerStats.addScore(1);
	}

}
