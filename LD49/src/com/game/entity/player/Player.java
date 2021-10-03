package com.game.entity.player;

import java.awt.image.BufferedImage;

import com.dependencyinjection.Inject;
import com.game.core.render.Render;
import com.game.entity.Entity;
import com.game.sprites.Sprites;

public class Player extends Entity {

	@Inject
	private PlayerInput playerInput;
	
	public Player() {
		moveTo(0, 100);
	}
	
	public BufferedImage getSprite() {
		return Sprites.playerRight1;
	}
	
	@Override
	public void tick() {
		playerInput.handleKeyInput();
		
		super.tick();
	}
	
	@Override
	public void render(Render render) {
		render.renderPlayer(getImageToRender());
	}
	
	private BufferedImage getImageToRender() {
		boolean useFrame1 = getMovementTicks() >= MOVEMENT_ANIMATION_TICKS / 2;
		
		if(useFrame1) {
			return getHurtTicks() > 0 ? Sprites.playerDamagedRight1 : Sprites.playerRight1;
		}
		
		return getHurtTicks() > 0 ? Sprites.playerDamagedRight2 : Sprites.playerRight2;
	}

}
