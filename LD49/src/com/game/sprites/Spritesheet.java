package com.game.sprites;

import java.awt.image.BufferedImage;

import com.game.core.images.ImageLoader;

public class Spritesheet {
	
	private BufferedImage spritesheet;
	private int spriteWidth;
	private int spriteHeight;
	
	public Spritesheet(String file, int spriteWidth, int spriteHeight) {
		this.spritesheet = ImageLoader.loadImage(file);
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	
	public BufferedImage getSprite(int row, int column) {
		int x = (spriteWidth * (column - 1));
		int y = (spriteHeight * (row - 1));
		
		return spritesheet.getSubimage(x, y, spriteWidth, spriteHeight);
	}

}
