package com.game.sprites;

import java.awt.image.BufferedImage;

import com.game.core.images.ImageLoader;

public class Sprites {
	
	// Mobs
	public static BufferedImage playerRight1;
	public static BufferedImage playerRight2;
	
	// Item entities
	
	// Object entities
	public static BufferedImage carMovingLeft;
	public static BufferedImage carMovingRight;
	
	// Backgrounds
	public static BufferedImage background1;
	
	public static void init() {
		Spritesheet player = new Spritesheet("/sprites/entities/player.png", 10, 14);
		playerRight1 = player.getSprite(1, 1);
		playerRight2 = player.getSprite(1, 2);
		
		carMovingLeft = ImageLoader.loadImage("/sprites/entities/car_left.png");
		carMovingRight = ImageLoader.loadImage("/sprites/entities/car_right.png");
		
		background1 = ImageLoader.loadImage("/backgrounds/background1.png");
	}

}
