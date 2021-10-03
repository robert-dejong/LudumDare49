package com.game.entity.items;

import java.awt.image.BufferedImage;

import com.game.Constants;
import com.game.entity.ItemEntity;
import com.game.sprites.Sprites;

public class BeerItemEntity extends ItemEntity {

	public BeerItemEntity(double x, double y) {
		super(x, y);
	}

	@Override
	public BufferedImage getSprite() {
		return Sprites.beer;
	}
	
	@Override
	public void onCollide() {
		playerStats.addHealth(1);
		playerStats.addScore(Constants.PICKUP_BEER_SCORE_INCREASE);
		super.onCollide();
	}

}
