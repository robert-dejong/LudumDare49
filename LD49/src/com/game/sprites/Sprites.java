package com.game.sprites;

import java.awt.image.BufferedImage;

import com.game.core.images.ImageLoader;

public class Sprites {
	
	// Mobs
	public static BufferedImage playerRight1;
	public static BufferedImage playerRight2;
	public static BufferedImage playerDamagedRight1;
	public static BufferedImage playerDamagedRight2;
	public static BufferedImage playerHealedRight1;
	public static BufferedImage playerHealedRight2;
	
	// Item entities
	public static BufferedImage beer;
	
	// Object entities
	public static BufferedImage carMovingLeft;
	public static BufferedImage carMovingRight;
	public static BufferedImage brokenGlass;
	
	// Backgrounds
	public static BufferedImage background1;
	
	public static void init() {
		Spritesheet player = new Spritesheet("/sprites/entities/player.png", 10, 14);
		playerRight1 = player.getSprite(1, 1);
		playerRight2 = player.getSprite(1, 2);
		playerDamagedRight1 = player.getSprite(1, 3);
		playerDamagedRight2 = player.getSprite(1, 4);
		playerHealedRight1 = player.getSprite(1, 5);
		playerHealedRight2 = player.getSprite(1, 6);
		
		carMovingLeft = ImageLoader.loadImage("/sprites/entities/car_left.png");
		carMovingRight = ImageLoader.loadImage("/sprites/entities/car_right.png");
		brokenGlass = ImageLoader.loadImage("/sprites/entities/broken_glass.png");
		
		background1 = ImageLoader.loadImage("/backgrounds/background1.png");
		
		beer = ImageLoader.loadImage("/sprites/entities/beer.png");
	}

}
