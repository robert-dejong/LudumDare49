package com.game.task;

import java.util.ArrayList;

import com.dependencyinjection.Inject;
import com.game.task.tasks.DoubleVisionEffectTask;
import com.game.task.tasks.GenerateBackgroundTask;
import com.game.task.tasks.IncreaseDifficultyTask;
import com.game.task.tasks.MovePlayerTask;
import com.game.task.tasks.ScoreTask;
import com.game.task.tasks.SpawnCarTask;
import com.game.task.tasks.SpawnItemTask;
import com.game.task.tasks.SpawnObstacleTask;

public class TaskManager {
	
	@Inject
	private DoubleVisionEffectTask doubleVisionEffectTask;
	
	@Inject
	private MovePlayerTask movePlayerTask;
	
	@Inject
	private ScoreTask scoreTask;
	
	@Inject
	private SpawnCarTask spawnCarTask;
	
	@Inject
	private SpawnObstacleTask spawnObstacleTask;
	
	@Inject
	private SpawnItemTask spawnItemTask;
	
	@Inject
	private IncreaseDifficultyTask increaseDifficultyTask;
	
	@Inject
	private GenerateBackgroundTask generateBackgroundTask;
	
	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void init() {
		add(doubleVisionEffectTask);
		add(movePlayerTask);
		add(scoreTask);
		add(spawnCarTask);
		add(spawnObstacleTask);
		add(spawnItemTask);
		add(increaseDifficultyTask);
		add(generateBackgroundTask);
	}
	
	public void tick() {
		tasks.forEach((task) -> {
			task.tick();
			
			if(task.getTicks() > 0)
				return;
			
			task.execute();
			task.setTicks(task.getInitialTicks());
			
			if(!task.isLoop()) {
				tasks.remove(task);
			}
		});
	}
	
	public void remove(String name) {
		tasks.forEach((task) -> {
			if(task.getName().equals(name)) {
				tasks.remove(task);
				return;
			}
		});
	}
	
	public void add(Task task) {
		tasks.add(task);
		task.onCreate();
	}
	
	public void reset() {
		tasks.forEach((task) -> {
			task.setTicks(task.getInitialTicks());
		});
	}

}
