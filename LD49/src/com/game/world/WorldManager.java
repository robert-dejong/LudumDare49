package com.game.world;

import java.util.ArrayList;

import com.game.core.render.Render;
import com.game.entity.Entity;

public class WorldManager {
	
	private ArrayList<Background> backgrounds;
	private ArrayList<Entity> entities;
	private ArrayList<Entity> entitiesToRemove;
	
	public WorldManager() {
		this.backgrounds = new ArrayList<Background>();
		this.entities = new ArrayList<Entity>();
		this.entitiesToRemove = new ArrayList<Entity>();
	}
	
	public void init() {
		spawnEntities();
	}
	
	public void tick() {
		entities.forEach((entity) -> {
			if(entity == null)
				return;
			
			entity.tick();
		});
	}
	
	public void render(Render render) {
		backgrounds.forEach((background) -> {
			background.render(render);
		});
		
		entities.forEach((entity) -> {
			if(entity == null)
				return;
			
			entity.render(render);
		});
	}
	
	public void spawnEntities() {
		
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public ArrayList<Entity> getEntitiesToRemove() {
		return entitiesToRemove;
	}
	
	public ArrayList<Background> getBackgrounds() {
		return backgrounds;
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		entitiesToRemove.add(entity);
	}
	
}
