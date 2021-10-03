package com.game.core;

import com.dependencyinjection.Inject;
import com.game.core.render.Render;
import com.game.entity.player.Player;
import com.game.entity.player.PlayerStats;
import com.game.task.TaskManager;
import com.game.world.WorldManager;

public class GameTick implements Runnable {
	
	@Inject
	private Render render;
	
	@Inject
	private Player player;
	
	@Inject
	private WorldManager worldManager;
	
	@Inject
	private TaskManager taskManager;
	
	@Inject
	private PlayerStats playerStats;
	
	public void init() {
		new Thread(this).start();
	}
	
	private void tick() {
		if (playerStats.getHealth() <= 0)
			return;
		
		player.tick();
		taskManager.tick();
		worldManager.tick();
		
		worldManager.getEntitiesToRemove().forEach((entity) -> {
			worldManager.getEntities().remove(entity);
		});
		
		worldManager.getEntitiesToRemove().clear();
	}
	
	@Override
	public void run() {
		double delta = 0;
		double nsPerTick = 1000000000.0 / 60;
		long last = System.nanoTime();
		long lastFps = System.currentTimeMillis();
		int frames = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - last) / nsPerTick;
			last = now;
			
			while(delta >= 1) {
				delta -= 1;
				tick();
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(System.currentTimeMillis() - lastFps >= 1000) {
				lastFps = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
			render.render();
			frames++;
		}
	}

}
