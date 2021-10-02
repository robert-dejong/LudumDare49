package com.game.world;

import java.awt.image.BufferedImage;

import com.game.core.render.Render;

public class Background {
	
	private BufferedImage image;
	private double x;
	
	public Background(BufferedImage image, double x) {
		this.image = image;
		this.x = x;
	}

	public void render(Render render) {
		render.render(image, (int)x, 0);
	}
	
	public BufferedImage getImage() {
		return image;
	}

}
