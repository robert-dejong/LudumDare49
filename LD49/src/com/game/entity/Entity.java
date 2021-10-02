package com.game.entity;

import java.awt.image.BufferedImage;

import com.dependencyinjection.Injector;
import com.game.Constants;
import com.game.core.render.Render;
import com.game.entity.player.PlayerStats;
import com.game.world.WorldManager;

public abstract class Entity {
	
	public final static int MOVEMENT_ANIMATION_TICKS = 18;
	
	public WorldManager worldManager = Injector.getInstance(WorldManager.class);
	public PlayerStats playerStats = Injector.getInstance(PlayerStats.class);
	
	private MovementDirection movementDirection = MovementDirection.LEFT;
	private int movementTicks = 0;
	private double x;
	private double y;
	
	public abstract BufferedImage getSprite();
	
	public Entity() { }
	
	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void onCollide() {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Render render) {
		render.render(getSprite(), (int)x - (getSprite().getWidth() / 2), (int)y - (getSprite().getHeight() / 2));
	}
	
	public void move(double x, double y) {
		double newX = this.x + x;
		double newY = this.y + y;
		
		if(!canMove(newX, newY)) {
			return;
		}
		
		increaseMovementTicks();
		movementDirection = getMovementDirection(newX, newY);
		moveTo(newX, newY);
	}
	
	public boolean canMove(double x, double y) {
		double feetY = y + (getSprite().getHeight() / 2);
		
		return (feetY > Constants.MIN_Y_POSITION && feetY < Constants.MAX_Y_POSITION);
	}
	
	public boolean collides(double x, double y, double otherX, double otherY, int otherWidth, int otherHeight) {
		int entityWidth = getSprite().getWidth() / 2;
		int entityHeight = getSprite().getHeight() / 2;
		
		int x2 = (int) (x - entityWidth);
		int y2 = (int) (y - entityHeight);
		int maxX = x2 + getSprite().getWidth();
		int maxY = y2 + getSprite().getHeight();
		
		int otherX2 = (int) (otherX - (otherWidth / 2));
		int otherY2 = (int) (otherY - (otherHeight / 2));
		
		int otherMaxX = otherX2 + otherWidth;
		int otherMaxY = otherY2 + otherHeight;
		
		return maxX >= otherX2 && x2 <= otherMaxX
				&& maxY > otherY2 && y2 + entityHeight <= otherMaxY;
	}
	
	public void moveTo(double x, double y) {
		this.setX(x);
		this.setY(y);
		
		// Check collision with other entities
		for(int i = 0; i < worldManager.getEntities().size(); i++) {
			Entity entity = worldManager.getEntities().get(i);
			
			if(entity == null || entity == this)
				return;
			
			if(this.collides(x, y, entity.getX(), entity.getY(), entity.getSprite().getWidth(), entity.getSprite().getHeight())) {
				this.onCollide();
				entity.onCollide();
			}
		}
	}
	
	public void moveToTile(int tileX, int tileY) {
		double x = (tileX * Constants.TILE_SIZE) + (getSprite().getWidth() / 2);
		double y = (tileY * Constants.TILE_SIZE) + (getSprite().getHeight() / 2);
		moveTo(x, y);
	}
	
	/*
	 
	 public void rotateToPlayer(double x, double y) {
		// Rotate towards player if mob is on screen
		if(Main.getInstance().onScreen(x, y, getImage().getWidth(), getImage().getHeight())) {
			
			double rotate = Math.atan2((Main.getInstance().getOptions().getHeight() / 2) - y, (Main.getInstance().getOptions().getWidth() / 2) - x);
			setRotation(Math.toDegrees(rotate));
			
			image = Sprites.rotate(getMobImage(), getRotation());

		}
	}
	 
	 public void walkToPlayer(double x, double y) {
		int playerX = (Main.getInstance().getOptions().getWidth() / 2);
		int playerY = (Main.getInstance().getOptions().getHeight() / 2);
		//int diffX = (playerX - x);
		//int diffY = (playerY - y);
		
		int speedX = (playerX > x ? getSpeed() : playerX < x ? -getSpeed() : 0);
		int speedY = (playerY > y ? getSpeed() : playerY < y ? -getSpeed() : 0);

		getPosition().setX(getPosition().getX() + speedX);
		getPosition().setY(getPosition().getY() + speedY);
		
		//if(diffX > diffY) {
		//	double speedX = (playerX > x ? getSpeed() : -getSpeed());
		//	double speedY = (playerY > y ? getSpeed() : -getSpeed());
		//	getPosition().setX((int)(getPosition().getX() + speedX));
		//	getPosition().setY((int)(getPosition().getY() + speedY));
		//} else {
		//	double speedX = (playerX > x ? getSpeed() : -getSpeed());
		//	double speedY = (playerY > y ? getSpeed() : -getSpeed());
		//	getPosition().setX((int)(getPosition().getX() + speedX));
		//	getPosition().setY((int)(getPosition().getY() + speedY));
		//}
		
		//System.out.println("DIFF X: " + diffX + ", diffY: " + diffY);
	}
	 
	 */
	
	public void increaseMovementTicks() {
		movementTicks++;
		
		if(movementTicks > MOVEMENT_ANIMATION_TICKS) {
			movementTicks = 0;
		}
	}
	
	public MovementDirection getMovementDirection(double newXPosition, double newYPosition) {
		if(newYPosition > getY())
			return MovementDirection.DOWN;
		else if(newYPosition < getY())
			return MovementDirection.UP;
		
		if(newXPosition > getX())
			return MovementDirection.RIGHT;
		else if(newXPosition < getX())
			return MovementDirection.LEFT;
		
		return MovementDirection.RIGHT;
	}
	
	public void remove() {
		worldManager.removeEntity(this);
	}
	
	public int getTileX(double x) {
		return (int)(x / Constants.TILE_SIZE);
	}
	
	public int getTileY(double y) {
		return (int)(y / Constants.TILE_SIZE);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public MovementDirection getMovementDirection() {
		return movementDirection;
	}

	public void setMovementDirection(MovementDirection movementDirection) {
		this.movementDirection = movementDirection;
	}
	
	public int getMovementTicks() {
		return movementTicks;
	}

	public void setMovementTicks(int movementTicks) {
		this.movementTicks = movementTicks;
	}
	
}
