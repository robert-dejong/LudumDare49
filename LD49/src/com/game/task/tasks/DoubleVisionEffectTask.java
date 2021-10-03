package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.core.render.Render;
import com.game.task.Task;

public class DoubleVisionEffectTask extends Task {
	
	private final static int TICKS_TO_WAIT = 40;
	private final static int MAX_OFFSET = 3;
	
	@Inject
	private Render render;
	
	private int direction = 0;
	
	public DoubleVisionEffectTask() {
		super(TICKS_TO_WAIT, true);
	}

	@Override
	public void execute() {
		int doubleVisionOffset = render.getDoubleVisionOffset();
		
		doubleVisionOffset += (direction == 0 ? 1 : -1);
		
		if(doubleVisionOffset == 0) {
			doubleVisionOffset = (direction == 0 ? 1 : -1);
		}
		
		if (doubleVisionOffset == MAX_OFFSET) {
			direction = 1;
		} else if (doubleVisionOffset == -MAX_OFFSET) {
			direction = 0;
		}
		
		render.setDoubleVisionOffset(doubleVisionOffset);
	}

}
