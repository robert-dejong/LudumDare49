package com.game.task;

import java.util.ArrayList;

import com.dependencyinjection.Inject;
import com.game.task.tasks.DoubleVisionEffectTask;
import com.game.task.tasks.MovePlayerTask;
import com.game.task.tasks.ScoreTask;
import com.game.task.tasks.SpawnCarTask;

public class TaskManager {
	
	@Inject
	private DoubleVisionEffectTask doubleVisionEffectTask;
	
	@Inject
	private MovePlayerTask movePlayerTask;
	
	@Inject
	private ScoreTask scoreTask;
	
	@Inject
	private SpawnCarTask spawnCarTask;
	
	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void init() {
		add(doubleVisionEffectTask);
		add(movePlayerTask);
		add(scoreTask);
		add(spawnCarTask);
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
	}

}
