package com.game.core.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.dependencyinjection.Inject;
import com.game.RestartGame;
import com.game.entity.player.PlayerStats;

public class MouseInput implements MouseListener {

	@Inject
	private PlayerStats playerStats;
	
	@Inject
	private RestartGame restartGame;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		if(!playerStats.isInMainMenu())
			return;
		
		int x = m.getX();
		int y = m.getY();
		
		int[] toggleDoubleVisionCoords = {26, 538, 301, 577};
		int[] startGameCoords = {239, 279, 545, 337};
		
		if(x > toggleDoubleVisionCoords[0] && y > toggleDoubleVisionCoords[1] && 
				x < toggleDoubleVisionCoords[2] && y < toggleDoubleVisionCoords[3]) {
			playerStats.toggleDoubleVisionEffect();
		}
		
		if(x > startGameCoords[0] && y > startGameCoords[1] && 
				x < startGameCoords[2] && y < startGameCoords[3]) {
			playerStats.setInMainMenu(false);
			restartGame.restart();
		}
	}

}
