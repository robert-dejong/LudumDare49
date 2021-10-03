package com.game.core.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.Constants;

public class ImageLoader {
	
	public static BufferedImage loadImage(String file) {
		String path = getPath(file);
		
		try {
			return ImageTransformer.toCompatibleImage(ImageIO.read(new File(path)));
			//return ImageTransformer.toCompatibleImage(ImageIO.read(ImageLoader.class.getClass().getResourceAsStream(path)));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String getPath(String file) {
		return Constants.DATA_PATH + file;
	}

}
