package com.game.entity.objects;

import java.awt.image.BufferedImage;

import com.game.Constants;
import com.game.entity.Entity;
import com.game.entity.player.DamageReason;
import com.game.sprites.Sprites;

public class CarEntity extends Entity {
	
	private int direction;
	
	public CarEntity(int tileX, int tileY, int direction) {
		this.moveToTile(tileX, tileY);
		this.direction = direction;
	}

	@Override
	public BufferedImage getSprite() {
		return direction == 0 ? Sprites.carMovingRight : Sprites.carMovingLeft;
	}

	@Override
	public void tick() {
		move(direction == 0 ? gameRules.getCarSpeed() : -(gameRules.getCarSpeed() - gameRules.getPlayerMovementSpeed()), 0);
	}
	
	@Override
	public void onCollide() {
		playerStats.removeHealth(Constants.PLAYER_MAX_HEALTH, DamageReason.HIT_BY_CAR);
		super.onCollide();
	}
}
