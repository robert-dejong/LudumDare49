package com.game.task.tasks;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.entity.player.Player;
import com.game.task.Task;
import com.game.world.Background;
import com.game.world.BackgroundFactory;
import com.game.world.WorldManager;

public class GenerateBackgroundTask extends Task {
	
	private final static int BACKGROUND_AMOUNT = 1;
	
	@Inject
	private Player player;
	
	@Inject
	private WorldManager worldManager;
	
	public GenerateBackgroundTask() {
		super(1, true);
	}

	@Override
	public void execute() {
		if(!shouldGenerateBackground())
			return;
		
		int tilesApart = Constants.SCREEN_WIDTH / Constants.RENDER_SCALE;
		
		int number = (int)(Math.random() * BACKGROUND_AMOUNT) + 1;
		int x = worldManager.getBackgrounds().size() * tilesApart;
		
		Background background = BackgroundFactory.Create(number, x);
		worldManager.getBackgrounds().add(background);
	}
	
	public boolean shouldGenerateBackground() {
		int lastBackgroundIndex = worldManager.getBackgrounds().size() - 1;
		
		if(lastBackgroundIndex < 0)
			return true;
		
		Background lastBackground = worldManager.getBackgrounds().get(lastBackgroundIndex);
		
		return player.getX() > lastBackground.getX();
	}

}
