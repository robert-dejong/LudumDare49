package com.game.entity.objects;

import java.awt.image.BufferedImage;

import com.game.entity.Entity;
import com.game.entity.player.DamageReason;
import com.game.sprites.Sprites;

public class BrokenGlassEntity extends Entity {
	
	private boolean steppedOn = false;
	
	public BrokenGlassEntity(double x, double y) {
		super(x, y);
	}

	@Override
	public BufferedImage getSprite() {
		return Sprites.brokenGlass;
	}
	
	@Override
	public void onCollide() {
		if(steppedOn)
			return;
		
		steppedOn = true;
		playerStats.removeHealth(2, DamageReason.STEPPED_IN_BROKEN_GLASS);
		super.onCollide();
	}
}
