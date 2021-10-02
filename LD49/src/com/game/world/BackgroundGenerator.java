package com.game.world;

import java.util.ArrayList;

import com.game.Constants;

public class BackgroundGenerator {
	
	private final static int BACKGROUND_AMOUNT = 1;
	
	public static ArrayList<Background> Generate() {
		ArrayList<Background> backgrounds = new ArrayList<Background>();
		int tilesApart = Constants.SCREEN_WIDTH / Constants.RENDER_SCALE;
		
		for(int i = 0; i < 10; i++) { // TODO: Generate when needed
			int number = (int)(Math.random() * BACKGROUND_AMOUNT) + 1;
			int x = i * tilesApart;
			
			Background background = BackgroundFactory.Create(number, x);
			backgrounds.add(background);
		}
		
		return backgrounds;
	}
}
