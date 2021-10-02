package com.game.world;

import java.util.ArrayList;

import com.game.core.render.Render;
import com.game.entity.Entity;

public class WorldManager {
	
	private ArrayList<Background> backgrounds;
	private ArrayList<Entity> entities;
	
	public WorldManager() {
		this.entities = new ArrayList<Entity>();
	}
	
	public void init() {
		this.backgrounds = BackgroundGenerator.Generate();
		spawnEntities();
	}
	
	public void tick() {
		entities.forEach((entity) -> {
			entity.tick();
		});
	}
	
	public void render(Render render) {
		backgrounds.forEach((background) -> {
			background.render(render);
		});
		
		entities.forEach((entity) -> {
			entity.render(render);
		});
	}
	
	public void spawnEntities() {
		
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
}
