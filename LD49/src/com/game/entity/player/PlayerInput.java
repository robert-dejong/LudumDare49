package com.game.entity.player;

import java.awt.event.KeyEvent;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.core.input.KeyboardInput;

public class PlayerInput {
	
	@Inject
	private Player player;
	
	@Inject
	private KeyboardInput keyboardInput;
	
	@Inject
	private PlayerStats playerStats;
	
	public void handleKeyInput() {
		double speed = Constants.PLAYER_MOVEMENT_SPEED;
		double moveY = 0;
		
		if(keyboardInput.isPressed(KeyEvent.VK_UP)) {
			moveY -= speed;
		}
		if(keyboardInput.isPressed(KeyEvent.VK_DOWN)) {
			moveY += speed;
		}
		
		if(keyboardInput.isPressed(KeyEvent.VK_1)) {
			playerStats.removeHealth(1, DamageReason.HIT_BY_CAR);
			keyboardInput.setPressed(KeyEvent.VK_1, false);
		}
		
		if(moveY != 0) {
			player.move(0, moveY);
		}
	}

}
