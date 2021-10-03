package com.game.entity.player;

import java.awt.event.KeyEvent;

import com.dependencyinjection.Inject;
import com.game.GameRules;
import com.game.RestartGame;
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
	
	@Inject
	private RestartGame restartGame;
	
	public void handleKeyInput() {
		
		if (playerStats.getHealth() <= 0 || playerStats.isInMainMenu()) {
			if(keyboardInput.isPressed(KeyEvent.VK_ENTER)) {
				playerStats.setInMainMenu(false);
				restartGame.restart();
				keyboardInput.setPressed(KeyEvent.VK_ENTER, false);
			}
			
			if(keyboardInput.isPressed(KeyEvent.VK_ESCAPE)) {
				playerStats.setInMainMenu(true);
				keyboardInput.setPressed(KeyEvent.VK_ESCAPE, false);
			}
			return;
		}
		
		double speed = gameRules.getPlayerMovementSpeed();
		double moveY = 0;
		
		if(keyboardInput.isPressed(KeyEvent.VK_UP) || keyboardInput.isPressed(KeyEvent.VK_W)) {
			moveY -= speed;
		}
		if(keyboardInput.isPressed(KeyEvent.VK_DOWN) || keyboardInput.isPressed(KeyEvent.VK_S)) {
			moveY += speed;
		}
		
		if(moveY != 0) {
			player.move(0, moveY);
		}
	}

}
