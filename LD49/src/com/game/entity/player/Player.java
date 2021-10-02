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
	}
	
	@Override
	public void render(Render render) {
		boolean useFrame1 = getMovementTicks() >= MOVEMENT_ANIMATION_TICKS / 2;
		render.renderPlayer(useFrame1 ? Sprites.playerRight1 : Sprites.playerRight2);
	}

}
