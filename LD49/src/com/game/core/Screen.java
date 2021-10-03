package com.game.core;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.core.input.KeyboardInput;
import com.game.core.input.MouseInput;
import com.game.core.render.Render;

public class Screen extends JFrame {
	
	@Inject
	private Render render;
	
	@Inject
	private KeyboardInput keyboardInput;
	
	@Inject
	private MouseInput mouseInput;
	
	private static final long serialVersionUID = 1L;
	
	public void init() {
		this.setTitle(Constants.TITLE);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		render.addKeyListener(keyboardInput);
		render.addMouseListener(mouseInput);
		this.add(render);
		this.revalidate();
		render.requestFocus();
	}

}
