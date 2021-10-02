package com.game;

import com.dependencyinjection.Injector;
import com.game.core.GameTick;
import com.game.core.Module;
import com.game.core.Screen;
import com.game.core.render.Render;
import com.game.sprites.Sprites;
import com.game.task.TaskManager;
import com.game.world.WorldManager;

public class Game {

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		Injector.Create(new Module());
		
		Screen screen = Injector.getInstance(Screen.class);
		Render render = Injector.getInstance(Render.class);
		GameTick gameTick = Injector.getInstance(GameTick.class);
		WorldManager worldManager = Injector.getInstance(WorldManager.class);
		TaskManager taskManager = Injector.getInstance(TaskManager.class);
		
		Sprites.init();
		worldManager.init();
		screen.init();
		render.init();
		gameTick.init();
		taskManager.init();
	}
	
}
