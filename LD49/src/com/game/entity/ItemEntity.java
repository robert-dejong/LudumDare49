package com.game.entity;

import com.game.sound.Sound;

public abstract class ItemEntity extends Entity {
	
	private final static double FLOATING_SPEED = 0.15;
	private final static int STATE_DURATION = 130;
	
	private int state = 0;
	
	public ItemEntity(double x, double y) {
		super(x, y);
	}
	
	@Override
	public void tick() {
		// Add floating effect to items
		state++;
		
		if(state >= STATE_DURATION) {
			state = 0;
		}
		
		if(state < STATE_DURATION / 2) {
			setY(getY() - FLOATING_SPEED);
		} else {
			setY(getY() + FLOATING_SPEED);
		}
	}

	@Override
	public void onCollide() {
		this.remove();
		Sound.item.play();
	}

}
