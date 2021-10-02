package com.game.core.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

	private boolean keysPressed[] = new boolean[1024];

	@Override
	public void keyPressed(KeyEvent k) {
		setPressed(k.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent k) {
		setPressed(k.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
	}
	
	public boolean isPressed(int keycode) {
		return keysPressed[keycode];
	}
	
	public void setPressed(int keycode, boolean pressed) {
		keysPressed[keycode] = pressed;
	}

}
