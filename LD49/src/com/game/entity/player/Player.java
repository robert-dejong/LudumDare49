package com.game.entity.player;

import java.awt.image.BufferedImage;

import com.game.core.render.Render;
import com.game.entity.Entity;
import com.game.sprites.Sprites;

public class Player extends Entity {
	
	public Player() {
		moveTo(0, 100);
	}
	
	public BufferedImage getSprite() {
		return Sprites.playerRight1;
	}
	
	@Override
	public void render(Render render) {
		render.renderPlayer(getImageToRender());
	}
	
	private BufferedImage getImageToRender() {
		boolean useFrame1 = getMovementTicks() >= MOVEMENT_ANIMATION_TICKS / 2;
		
		if(getHurtTicks() > 0) {
			return useFrame1 ? Sprites.playerDamagedRight1 : Sprites.playerDamagedRight2;
		}
		
		if(getHealedTicks() > 0) {
			return useFrame1 ? Sprites.playerHealedRight1 : Sprites.playerHealedRight2;
		}
		
		return useFrame1 ? Sprites.playerRight1 : Sprites.playerRight2;
	}

}
