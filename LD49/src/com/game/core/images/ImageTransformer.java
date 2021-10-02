package com.game.core.images;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

public class ImageTransformer {
	
	/**
	 * Optimize the image
	 * 
	 * @param image to optimize
	 * @return the optimized image
	 */
	public static BufferedImage toCompatibleImage(BufferedImage image)
	{
		// obtain the current system graphical settings
		GraphicsConfiguration gfxConfig = GraphicsEnvironment.
			getLocalGraphicsEnvironment().getDefaultScreenDevice().
			getDefaultConfiguration();

		/*
		 * if image is already compatible and optimized for current system 
		 * settings, simply return it
		 */
		if (image.getColorModel().equals(gfxConfig.getColorModel()))
			return image;

		// image is not optimized, so create a new image that is
		BufferedImage new_image = gfxConfig.createCompatibleImage(
				image.getWidth(), image.getHeight(), image.getTransparency());

		// get the graphics context of the new image to draw the old image on
		Graphics2D g2d = (Graphics2D) new_image.getGraphics();

		// actually draw the image and dispose of context no longer needed
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		// return the new optimized image
		return new_image; 
	}
	
	/**
	 * Rotate an image
	 * 
	 * @param image to rotate
	 * @param degrees to rotate the image
	 * @return the rotated image
	 */
	public static BufferedImage rotate(BufferedImage image, double degrees) {
		BufferedImage rotate = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) rotate.getGraphics();
		g2.rotate(Math.toRadians(degrees), image.getWidth() / 2, image.getHeight() / 2);
		
		g2.drawImage(image, 0, 0, null);
		rotate = toCompatibleImage(rotate);
		return rotate;
	}

}
