package com.game.entity.player;

import java.awt.event.KeyEvent;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.core.input.KeyboardInput;

public class PlayerInput {
	
	@Inject
	private Player player;
	
	@Inject
	private KeyboardInput keyboardInput;
	
	@Inject
	private PlayerStats playerStats;
	
	@Inject
	private GameRules gameRules;
	
	public void handleKeyInput() {
		double speed = gameRules.getPlayerMovementSpeed();
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
