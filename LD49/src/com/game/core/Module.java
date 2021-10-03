package com.game.core;

import com.dependencyinjection.InjectionModule;
import com.game.GameRules;
import com.game.core.input.KeyboardInput;
import com.game.core.render.Render;
import com.game.entity.player.Player;
import com.game.entity.player.PlayerInput;
import com.game.entity.player.PlayerStats;
import com.game.task.TaskManager;
import com.game.task.tasks.DoubleVisionEffectTask;
import com.game.task.tasks.GenerateBackgroundTask;
import com.game.task.tasks.IncreaseDifficultyTask;
import com.game.task.tasks.MovePlayerTask;
import com.game.task.tasks.ScoreTask;
import com.game.task.tasks.SpawnCarTask;
import com.game.task.tasks.SpawnItemTask;
import com.game.task.tasks.SpawnObstacleTask;
import com.game.world.WorldManager;

public class Module extends InjectionModule {

	@Override
	public void configure() {
		this.bindSingleton(DoubleVisionEffectTask.class);
		this.bindSingleton(MovePlayerTask.class);
		this.bindSingleton(ScoreTask.class);
		this.bindSingleton(SpawnCarTask.class);
		this.bindSingleton(SpawnObstacleTask.class);
		this.bindSingleton(SpawnItemTask.class);
		this.bindSingleton(IncreaseDifficultyTask.class);
		this.bindSingleton(WorldManager.class);
		this.bindSingleton(Screen.class);
		this.bindSingleton(Render.class);
		this.bindSingleton(GameTick.class);
		this.bindSingleton(KeyboardInput.class);
		this.bindSingleton(TaskManager.class);
		this.bindSingleton(Player.class);
		this.bindSingleton(PlayerInput.class);
		this.bindSingleton(PlayerStats.class);
		this.bindSingleton(GameRules.class);
		this.bindSingleton(GenerateBackgroundTask.class);
	}
}
