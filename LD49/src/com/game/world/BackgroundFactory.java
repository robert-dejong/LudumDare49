package com.game.world;

import com.game.sprites.Sprites;

public class BackgroundFactory {
	
	public static Background Create(int backgroundNumber, int tileX) {
		switch(backgroundNumber) {
		case 1:
			return new Background(Sprites.background1, tileX);
		}
		
		return null;
	}

}
